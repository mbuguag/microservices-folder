package com.example.milk_processing.controller;


import com.example.milk_processing.entity.MilkProcessing;
import com.example.milk_processing.service.MilkProcessingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/milk-processing")
public class MilkProcessingController {
    private final MilkProcessingService milkProcessingService;

    public MilkProcessingController(MilkProcessingService milkProcessingService) {
        this.milkProcessingService = milkProcessingService;
    }

    @GetMapping
    public List<MilkProcessing> getAllProcessingRecords() {
        return milkProcessingService.getAllProcessingRecords();
    }

    @PostMapping
    public MilkProcessing addProcessingRecord(@RequestBody MilkProcessing processing) {
        return milkProcessingService.saveProcessingRecord(processing);
    }

    @GetMapping("/status/{status}")
    public List<MilkProcessing> getProcessingByStatus(@PathVariable String status) {
        return milkProcessingService.getProcessingByStatus(status);
    }
}

