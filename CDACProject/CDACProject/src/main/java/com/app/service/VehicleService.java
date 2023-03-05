package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Vehicle;


public interface VehicleService {

	public List<Vehicle> getAllVehicleDetails();
	
	public Optional<Vehicle> getVehicleDetails(Long vehicleId);
	
	public Vehicle addVehicleDetails(Vehicle transientVehicle);
	
	public Vehicle updateVehicleDetails(Vehicle detachedVehicle);
	
	public String deleteVehicleDetails(Long vehicleId);
	
}//End of VehicleService
