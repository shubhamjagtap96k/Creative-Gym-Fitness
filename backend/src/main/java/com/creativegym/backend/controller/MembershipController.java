package com.creativegym.backend.controller;

import com.creativegym.backend.model.Membership;
import com.creativegym.backend.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memberships")
public class MembershipController {

    @Autowired
    private MembershipService membershipService;

    @PostMapping("/assign")
    public ResponseEntity<Membership> assignPlan(@RequestParam Long userId, @RequestParam Long planId,
            @RequestParam Long adminId) {
        // In real app, adminId would be from SecurityContext
        return ResponseEntity.ok(membershipService.assignPlan(userId, planId, adminId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Membership>> getUserMemberships(@PathVariable Long userId) {
        return ResponseEntity.ok(membershipService.getUserMemberships(userId));
    }
}
