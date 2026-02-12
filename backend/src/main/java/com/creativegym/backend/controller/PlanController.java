package com.creativegym.backend.controller;

import com.creativegym.backend.dto.PlanDto;
import com.creativegym.backend.service.GymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class PlanController {

    @Autowired
    private GymService gymService;

    @GetMapping
    public ResponseEntity<List<PlanDto>> getParams() {
        return ResponseEntity.ok(gymService.getAllPublicPlans());
    }

    @GetMapping("/admin")
    public ResponseEntity<List<PlanDto>> getAllPlansAdmin() {
        return ResponseEntity.ok(gymService.getAllPlansRequiredAdmin());
    }

    @PostMapping
    public ResponseEntity<PlanDto> createPlan(@RequestBody PlanDto dto) {
        return ResponseEntity.ok(gymService.createPlan(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanDto> updatePlan(@PathVariable Long id, @RequestBody PlanDto dto) {
        return ResponseEntity.ok(gymService.updatePlan(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(@PathVariable Long id) {
        gymService.deletePlan(id);
        return ResponseEntity.noContent().build();
    }
}
