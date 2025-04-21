package com.example.FarmerService.controller;

import com.example.FarmerService.entity.Farmer;
import com.example.FarmerService.helper.ExcelHelper;
import com.example.FarmerService.service.FarmerExcelService;
import com.example.FarmerService.service.FarmerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/farmers")
@Tag(name = "Farmer Controller", description = "Handles CRUD operations and Excel uploads for farmers")
public class FarmerController {

    private final FarmerService farmerService;
    private final FarmerExcelService farmerExcelService;

    public FarmerController(FarmerService farmerService, FarmerExcelService farmerExcelService) {
        this.farmerService = farmerService;
        this.farmerExcelService = farmerExcelService;
    }

    @PostMapping
    public ResponseEntity<Farmer> createFarmer(@RequestBody Farmer farmer) {
        return new ResponseEntity<>(farmerService.createFarmer(farmer), HttpStatus.CREATED);
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadExcelFile(@RequestParam("file") MultipartFile file) {
        if (ExcelHelper.hasExcelFormat(file)) {
            farmerExcelService.processAndSendToQueue(file);
            return ResponseEntity.ok("Uploaded successfully!");
        }
        return ResponseEntity.badRequest().body("Please upload a valid Excel file!");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Farmer> getFarmer(@PathVariable Long id) {
        return ResponseEntity.ok(farmerService.getFarmerById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farmer> updateFarmer(@PathVariable Long id, @RequestBody Farmer farmer) {
        return ResponseEntity.ok(farmerService.updateFarmer(id, farmer));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmer(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Farmer>> getAllFarmers() {
        return ResponseEntity.ok(farmerService.getAllFarmers());
    }
}
