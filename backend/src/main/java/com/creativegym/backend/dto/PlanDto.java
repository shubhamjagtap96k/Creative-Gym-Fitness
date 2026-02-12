package com.creativegym.backend.dto;

import lombok.Data;
import java.util.List;

@Data
public class PlanDto {
    private Long id;
    private String name;
    private String term; // MONTHLY, ANNUAL, CUSTOM
    private String description;
    private List<String> features;
    private int classCreditsPerTerm;
    private int ptSessionsPerTerm;
    private int dietDepthTier;
    private boolean isActive;
    private String visibility; // PUBLIC, PRIVATE
}
