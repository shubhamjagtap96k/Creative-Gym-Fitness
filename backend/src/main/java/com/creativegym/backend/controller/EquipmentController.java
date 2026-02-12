package com.creativegym.backend.controller;

import com.creativegym.backend.model.Equipment;
import com.creativegym.backend.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public ResponseEntity<List<Equipment>> getAll() {
        return ResponseEntity.ok(equipmentService.getAllEquipment());
    }

    @PostMapping
    public ResponseEntity<Equipment> create(@RequestBody Equipment equipment) {
        return ResponseEntity.ok(equipmentService.createEquipment(equipment));
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Equipment> updateStatus(@PathVariable Long id, @RequestParam String status) {
        // Simple string to enum mapping
        return ResponseEntity.ok(equipmentService.updateStatus(id, Equipment.EquipmentStatus.valueOf(status)));
    }
}
