package com.creativegym.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "equipment")
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String category;
    private String photoUrl;
    private LocalDate purchaseDate;

    @Enumerated(EnumType.STRING)
    private EquipmentStatus status = EquipmentStatus.OK;

    private LocalDate lastServiceAt;

    @Column(columnDefinition = "TEXT")
    private String notes;

    private String zone;

    public enum EquipmentStatus {
        OK,
        MAINTENANCE,
        DOWN
    }
}
