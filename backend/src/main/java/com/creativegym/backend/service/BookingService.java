package com.creativegym.backend.service;

import com.creativegym.backend.dto.GymClassDto;
import com.creativegym.backend.model.GymClass;
import com.creativegym.backend.model.TrainerProfile;
import com.creativegym.backend.model.User;
import com.creativegym.backend.repository.BookingRepository;
import com.creativegym.backend.repository.GymClassRepository;
import com.creativegym.backend.repository.TrainerProfileRepository;
import com.creativegym.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    @Autowired
    private GymClassRepository gymClassRepository;

    @Autowired
    private TrainerProfileRepository trainerProfileRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    public List<GymClassDto> getAllClasses() {
        return gymClassRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    public GymClassDto createClass(GymClassDto dto) {
        GymClass gymClass = new GymClass();
        gymClass.setTitle(dto.getTitle());
        gymClass.setDescription(dto.getDescription());
        gymClass.setStartAt(dto.getStartAt());
        gymClass.setEndAt(dto.getEndAt());
        gymClass.setCapacity(dto.getCapacity());
        gymClass.setLocation(dto.getLocation());
        gymClass.setRecurring(dto.isRecurring());

        if (dto.getTrainerId() != null) {
            TrainerProfile trainer = trainerProfileRepository.findById(dto.getTrainerId())
                    .orElseThrow(() -> new RuntimeException("Trainer not found"));
            gymClass.setTrainer(trainer);
        }

        return mapToDto(gymClassRepository.save(gymClass));
    }

    @Transactional
    public void bookClass(Long classId, Long userId) {
        GymClass gymClass = gymClassRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("Class not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check capacity
        List<com.creativegym.backend.model.Booking> existingBookings = bookingRepository.findByGymClassId(classId);
        long activeBookings = existingBookings.stream()
                .filter(b -> b.getStatus() == com.creativegym.backend.model.Booking.BookingStatus.BOOKED)
                .count();

        if (activeBookings >= gymClass.getCapacity()) {
            throw new RuntimeException("Class is full");
        }

        com.creativegym.backend.model.Booking booking = new com.creativegym.backend.model.Booking();
        booking.setGymClass(gymClass);
        booking.setUser(user);
        booking.setStatus(com.creativegym.backend.model.Booking.BookingStatus.BOOKED);

        bookingRepository.save(booking);
    }

    private GymClassDto mapToDto(GymClass gymClass) {
        GymClassDto dto = new GymClassDto();
        dto.setId(gymClass.getId());
        dto.setTitle(gymClass.getTitle());
        dto.setDescription(gymClass.getDescription());
        dto.setStartAt(gymClass.getStartAt());
        dto.setEndAt(gymClass.getEndAt());
        dto.setCapacity(gymClass.getCapacity());
        dto.setLocation(gymClass.getLocation());
        dto.setRecurring(gymClass.isRecurring());

        if (gymClass.getTrainer() != null) {
            dto.setTrainerId(gymClass.getTrainer().getId());
            if (gymClass.getTrainer().getUser() != null) {
                dto.setTrainerName(gymClass.getTrainer().getUser().getName());
            }
        }
        return dto;
    }
}
