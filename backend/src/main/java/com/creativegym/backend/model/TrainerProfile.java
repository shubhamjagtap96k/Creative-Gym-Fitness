package com.creativegym.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "trainer_profiles")
public class TrainerProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(columnDefinition = "TEXT")
    private String certsJson;

    private String specialties;
    private String photoUrl;

    @Column(columnDefinition = "TEXT")
    private String availabilityJson;

    private String rateNote;
}
