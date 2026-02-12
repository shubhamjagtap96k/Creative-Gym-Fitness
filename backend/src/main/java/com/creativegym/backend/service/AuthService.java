package com.creativegym.backend.service;

import com.creativegym.backend.config.JwtUtil;
import com.creativegym.backend.dto.AuthDto;
import com.creativegym.backend.model.MemberProfile;
import com.creativegym.backend.model.Role;
import com.creativegym.backend.model.User;
import com.creativegym.backend.repository.MemberProfileRepository;
import com.creativegym.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MemberProfileRepository memberProfileRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Transactional
    public AuthDto.AuthResponse register(AuthDto.RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already active");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setPasswordHash(passwordEncoder.encode(request.getPassword()));
        user.setRole(request.getRole() != null ? request.getRole() : Role.MEMBER);

        User savedUser = userRepository.save(user);

        if (savedUser.getRole() == Role.MEMBER) {
            MemberProfile profile = new MemberProfile();
            profile.setUser(savedUser);
            memberProfileRepository.save(profile);
        }

        String token = jwtUtil.generateToken(savedUser.getEmail(), savedUser.getRole().name());
        return new AuthDto.AuthResponse(token, savedUser.getName(), savedUser.getRole().name());
    }

    public AuthDto.AuthResponse login(AuthDto.LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getEmail(), user.getRole().name());
        return new AuthDto.AuthResponse(token, user.getName(), user.getRole().name());
    }
}
