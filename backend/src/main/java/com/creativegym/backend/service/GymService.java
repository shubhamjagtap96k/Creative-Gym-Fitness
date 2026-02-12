package com.creativegym.backend.service;

import com.creativegym.backend.dto.PlanDto;
import com.creativegym.backend.model.Plan;
import com.creativegym.backend.repository.PlanRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GymService {

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private ObjectMapper objectMapper;

    // Public Plans
    public List<PlanDto> getAllPublicPlans() {
        return planRepository.findByIsActiveTrue().stream()
                .filter(p -> p.getVisibility() == Plan.PlanVisibility.PUBLIC)
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    // Admin Plans
    public List<PlanDto> getAllPlansRequiredAdmin() {
        return planRepository.findAll().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public PlanDto createPlan(PlanDto dto) {
        Plan plan = mapToEntity(dto);
        return mapToDto(planRepository.save(plan));
    }

    public PlanDto updatePlan(Long id, PlanDto dto) {
        Plan plan = planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan not found"));
        updateEntity(plan, dto);
        return mapToDto(planRepository.save(plan));
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }

    private PlanDto mapToDto(Plan plan) {
        PlanDto dto = new PlanDto();
        dto.setId(plan.getId());
        dto.setName(plan.getName());
        dto.setTerm(plan.getTerm().name());
        dto.setDescription(plan.getDescription());
        dto.setClassCreditsPerTerm(plan.getClassCreditsPerTerm());
        dto.setPtSessionsPerTerm(plan.getPtSessionsPerTerm());
        dto.setDietDepthTier(plan.getDietDepthTier());
        dto.setActive(plan.isActive());
        dto.setVisibility(plan.getVisibility().name());

        try {
            if (plan.getFeaturesJson() != null) {
                dto.setFeatures(objectMapper.readValue(plan.getFeaturesJson(), new TypeReference<List<String>>() {
                }));
            } else {
                dto.setFeatures(Collections.emptyList());
            }
        } catch (JsonProcessingException e) {
            dto.setFeatures(Collections.emptyList());
        }
        return dto;
    }

    private Plan mapToEntity(PlanDto dto) {
        Plan plan = new Plan();
        updateEntity(plan, dto);
        return plan;
    }

    private void updateEntity(Plan plan, PlanDto dto) {
        plan.setName(dto.getName());
        if (dto.getTerm() != null) {
            plan.setTerm(Plan.PlanTerm.valueOf(dto.getTerm()));
        }
        plan.setDescription(dto.getDescription());
        plan.setClassCreditsPerTerm(dto.getClassCreditsPerTerm());
        plan.setPtSessionsPerTerm(dto.getPtSessionsPerTerm());
        plan.setDietDepthTier(dto.getDietDepthTier());
        plan.setActive(dto.isActive());
        if (dto.getVisibility() != null) {
            plan.setVisibility(Plan.PlanVisibility.valueOf(dto.getVisibility()));
        }

        try {
            if (dto.getFeatures() != null) {
                plan.setFeaturesJson(objectMapper.writeValueAsString(dto.getFeatures()));
            }
        } catch (JsonProcessingException e) {
            plan.setFeaturesJson("[]");
        }
    }
}
