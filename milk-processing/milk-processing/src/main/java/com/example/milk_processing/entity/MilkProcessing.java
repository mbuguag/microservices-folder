package com.example.milk_processing.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class MilkProcessing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String batchNumber;
    private String processingStage; // Pasteurization, Homogenization, Packaging, etc.
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status; // In Progress, Completed, Failed

//    @ManyToOne
//    @JoinColumn(name = "employee_id", nullable = false)
//    private Employee assignedEmployee;
}

