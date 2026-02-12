package com.creativegym.backend.controller;

import com.creativegym.backend.dto.GymClassDto;
import com.creativegym.backend.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<GymClassDto>> getAllClasses() {
        return ResponseEntity.ok(bookingService.getAllClasses());
    }

    @PostMapping
    public ResponseEntity<GymClassDto> createClass(@RequestBody GymClassDto dto) {
        return ResponseEntity.ok(bookingService.createClass(dto));
    }

    @PostMapping("/{classId}/book")
    public ResponseEntity<Void> bookClass(@PathVariable Long classId, @RequestParam Long userId) {
        bookingService.bookClass(classId, userId);
        return ResponseEntity.ok().build();
    }
}
