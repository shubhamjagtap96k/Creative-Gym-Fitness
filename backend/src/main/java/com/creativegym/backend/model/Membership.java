package com.creativegym.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @Enumerated(EnumType.STRING)
    private MembershipStatus status = MembershipStatus.PENDING;

    private LocalDate startAt;
    private LocalDate endAt;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "assigned_by_user_id")
    private User assignedBy;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedAt;

    public enum MembershipStatus {
        PENDING,
        ACTIVE,
        PAUSED,
        EXPIRED,
        CANCELLED
    }
}
