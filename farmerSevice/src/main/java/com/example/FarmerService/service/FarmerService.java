package com.example.FarmerService.service;

import com.example.FarmerService.entity.Farmer;

import java.util.List;

public interface FarmerService {
    Farmer createFarmer(Farmer farmer);
    Farmer updateFarmer(Long id, Farmer farmer);
    void deleteFarmer(Long id);
    Farmer getFarmerById(Long id);
    List<Farmer> getAllFarmers();

}
