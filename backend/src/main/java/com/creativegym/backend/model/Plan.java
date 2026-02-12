package com.creativegym.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "plans")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private PlanTerm term;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT")
    private String featuresJson;

    private int classCreditsPerTerm;
    private int ptSessionsPerTerm;
    private int dietDepthTier; // 1=Basic, 2=Advanced, etc.

    private boolean isActive = true;

    @Enumerated(EnumType.STRING)
    private PlanVisibility visibility = PlanVisibility.PUBLIC;

    public enum PlanTerm {
        MONTHLY,
        ANNUAL,
        CUSTOM
    }

    public enum PlanVisibility {
        PUBLIC,
        PRIVATE
    }
}
