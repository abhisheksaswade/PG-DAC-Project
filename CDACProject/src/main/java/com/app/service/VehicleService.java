package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Vehicle;


public interface VehicleService {
	
//********************* standard method declaration*****************************************************************
	//GET ALL
	public List<Vehicle> getAllVehicleDetails();
	
	//GET BY ID
	public Optional<Vehicle> getVehicleDetails(Long vehicleId);
	
	//INSERT
	public Vehicle addVehicleDetails(Vehicle transientVehicle);
	
	//UPDATE
	public Vehicle updateVehicleDetails(Vehicle detachedVehicle);
	
	//DELETE
	public String deleteVehicleDetails(Long vehicleId);
	
}//End of VehicleService
