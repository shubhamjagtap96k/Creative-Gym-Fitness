package com.creativegym.backend.service;

import com.creativegym.backend.model.DietTemplate;
import com.creativegym.backend.model.WorkoutTemplate;
import com.creativegym.backend.repository.DietTemplateRepository;
import com.creativegym.backend.repository.WorkoutTemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentService {

    @Autowired
    private DietTemplateRepository dietTemplateRepository;

    @Autowired
    private WorkoutTemplateRepository workoutTemplateRepository;

    public List<DietTemplate> getAllDietTemplates() {
        return dietTemplateRepository.findAll();
    }

    public DietTemplate createDietTemplate(DietTemplate template) {
        return dietTemplateRepository.save(template);
    }

    public List<WorkoutTemplate> getAllWorkoutTemplates() {
        return workoutTemplateRepository.findAll();
    }

    public WorkoutTemplate createWorkoutTemplate(WorkoutTemplate template) {
        return workoutTemplateRepository.save(template);
    }
}
