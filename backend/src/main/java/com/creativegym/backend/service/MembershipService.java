package com.creativegym.backend.service;

import com.creativegym.backend.model.Membership;
import com.creativegym.backend.model.Plan;
import com.creativegym.backend.model.User;
import com.creativegym.backend.repository.MembershipRepository;
import com.creativegym.backend.repository.PlanRepository;
import com.creativegym.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class MembershipService {

    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Membership assignPlan(Long userId, Long planId, Long assignedByUserId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Plan plan = planRepository.findById(planId).orElseThrow(() -> new RuntimeException("Plan not found"));
        User assigner = userRepository.findById(assignedByUserId)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        Membership membership = new Membership();
        membership.setUser(user);
        membership.setPlan(plan);
        membership.setAssignedBy(assigner);
        membership.setStatus(Membership.MembershipStatus.ACTIVE);
        membership.setStartAt(LocalDate.now());

        // Calculate end date based on PlanTerm
        if (plan.getTerm() == Plan.PlanTerm.MONTHLY) {
            membership.setEndAt(LocalDate.now().plusMonths(1));
        } else if (plan.getTerm() == Plan.PlanTerm.ANNUAL) {
            membership.setEndAt(LocalDate.now().plusYears(1));
        } else {
            // Custom or undefined, default to 1 month or handle null
            membership.setEndAt(LocalDate.now().plusMonths(1));
        }

        return membershipRepository.save(membership);
    }

    public List<Membership> getUserMemberships(Long userId) {
        return membershipRepository.findByUserId(userId);
    }
}
