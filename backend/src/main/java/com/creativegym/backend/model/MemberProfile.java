package com.creativegym.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "member_profiles")
public class MemberProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private LocalDate dob;
    private String gender;
    private String address;
    private String emergencyContact;

    @Column(columnDefinition = "TEXT")
    private String healthParqJson;

    @Column(columnDefinition = "TEXT")
    private String goals;

    @Column(columnDefinition = "TEXT")
    private String preferencesJson;

    @Column(columnDefinition = "TEXT")
    private String metricsJson;
}
