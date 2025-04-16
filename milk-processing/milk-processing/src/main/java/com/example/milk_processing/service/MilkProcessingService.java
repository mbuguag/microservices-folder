package com.example.milk_processing.service;

import com.example.milk_processing.entity.MilkProcessing;
import com.example.milk_processing.repository.MilkProcessingRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MilkProcessingService {
    private final MilkProcessingRepository milkProcessingRepository;

    public MilkProcessingService(MilkProcessingRepository milkProcessingRepository) {
        this.milkProcessingRepository = milkProcessingRepository;
    }

    public List<MilkProcessing> getAllProcessingRecords() {
        return milkProcessingRepository.findAll();
    }

    public MilkProcessing saveProcessingRecord(MilkProcessing processing) {
        return milkProcessingRepository.save(processing);
    }

    public List<MilkProcessing> getProcessingByStatus(String status) {
        return milkProcessingRepository.findByStatus(status);
    }
}

