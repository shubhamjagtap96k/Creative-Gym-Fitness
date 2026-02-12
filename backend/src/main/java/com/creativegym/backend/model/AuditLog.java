package com.creativegym.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "audit_logs")
public class AuditLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long actorUserId;

    @Column(nullable = false)
    private String action;

    private String resource;

    @Column(columnDefinition = "TEXT")
    private String dataJson;

    private String ip;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
