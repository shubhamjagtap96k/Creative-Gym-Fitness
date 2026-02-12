package com.creativegym.backend.controller;

import com.creativegym.backend.model.DietTemplate;
import com.creativegym.backend.model.WorkoutTemplate;
import com.creativegym.backend.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping("/diets")
    public ResponseEntity<List<DietTemplate>> getAllDiets() {
        return ResponseEntity.ok(contentService.getAllDietTemplates());
    }

    @PostMapping("/diets")
    public ResponseEntity<DietTemplate> createDiet(@RequestBody DietTemplate template) {
        return ResponseEntity.ok(contentService.createDietTemplate(template));
    }

    @GetMapping("/workouts")
    public ResponseEntity<List<WorkoutTemplate>> getAllWorkouts() {
        return ResponseEntity.ok(contentService.getAllWorkoutTemplates());
    }

    @PostMapping("/workouts")
    public ResponseEntity<WorkoutTemplate> createWorkout(@RequestBody WorkoutTemplate template) {
        return ResponseEntity.ok(contentService.createWorkoutTemplate(template));
    }
}
