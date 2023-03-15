package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Vehicle;
import com.app.repository.VehicleDao;

@Service
@Transactional
public class VehicleServiceImplementation implements VehicleService {

//*********************dependency injection****************************************************************************	
	@Autowired
	private VehicleDao vehicleRepo;

	
//*********************method implementation****************************************************************************	
	@Override
	public List<Vehicle> getAllVehicleDetails() {
		return vehicleRepo.findAll();
	}

	@Override
	public Optional<Vehicle> getVehicleDetails(Long vehicleId) {
		return vehicleRepo.findById(vehicleId);
	}

	@Override
	public Vehicle addVehicleDetails(Vehicle transientVehicle) {
		return vehicleRepo.save(transientVehicle);
	}

	@Override
	public Vehicle updateVehicleDetails(Vehicle detachedVehicle) {
		return vehicleRepo.save(detachedVehicle);
	}

	@Override
	public String deleteVehicleDetails(Long vehicleId) {
		if(vehicleRepo.existsById(vehicleId))
		{
			vehicleRepo.deleteById(vehicleId);
			return "Vehicle Sucessfully Deleted......";
		}

		return "Vehicle Deletion Failed......";
	}
		
}//End of VehicleServiceImplementation
