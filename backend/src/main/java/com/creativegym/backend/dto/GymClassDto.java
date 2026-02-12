package com.creativegym.backend.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class GymClassDto {
    private Long id;
    private String title;
    private String description;
    private Long trainerId;
    private String trainerName;
    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private int capacity;
    private String location;
    private boolean isRecurring;
}
