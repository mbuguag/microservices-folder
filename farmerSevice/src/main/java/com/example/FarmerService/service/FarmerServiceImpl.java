package com.example.FarmerService.service;

import com.example.FarmerService.entity.Farmer;
import com.example.FarmerService.repository.FarmerRepository;
import com.example.FarmerService.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmerServiceImpl implements FarmerService {

    private final FarmerRepository farmerRepository;

    public FarmerServiceImpl(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    @Override
    public Farmer createFarmer(Farmer farmer) {
        return farmerRepository.save(farmer);
    }

    @Override
    public Farmer updateFarmer(Long id, Farmer updatedFarmer) {
        Farmer existing = farmerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not found with ID: " + id));
        existing.setFullName(updatedFarmer.getFullName());
        existing.setEmail(updatedFarmer.getEmail());
        existing.setPhoneNumber(updatedFarmer.getPhoneNumber());
        existing.setLocation(updatedFarmer.getLocation());
        return farmerRepository.save(existing);
    }

    @Override
    public void deleteFarmer(Long id) {
        if (!farmerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Farmer not found with ID: " + id);
        }
        farmerRepository.deleteById(id);
    }

    @Override
    public Farmer getFarmerById(Long id) {
        return farmerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Farmer not found with ID: " + id));
    }

    @Override
    public List<Farmer> getAllFarmers() {
        return farmerRepository.findAll();
    }
}
