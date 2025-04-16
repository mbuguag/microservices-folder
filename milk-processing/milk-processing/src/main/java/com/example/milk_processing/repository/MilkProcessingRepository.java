package com.example.milk_processing.repository;


import com.example.milk_processing.entity.MilkProcessing;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MilkProcessingRepository extends JpaRepository<MilkProcessing, Long> {
    List<MilkProcessing> findByStatus(String status);
}

