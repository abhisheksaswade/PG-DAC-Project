package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.MyOrder;
import com.app.entities.Vehicle;
import com.app.service.VehicleService;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	
	
//*********************dependency injection****************************************************************************	
	@Autowired
	private VehicleService vehicleService;
	
	
//*********************method implementation****************************************************************************		
	@GetMapping
	public List<Vehicle> getAllVehicle()
	{
		return vehicleService.getAllVehicleDetails();
	}
	
	@GetMapping("/{vehicleId}")
	public Optional<Vehicle> getVehicle(@PathVariable Long vehicleId)
	{
		return vehicleService.getVehicleDetails(vehicleId);
	}
	
	@PostMapping
	public Vehicle addVehicle(@RequestBody Vehicle transientVehicle)
	{
		return vehicleService.addVehicleDetails(transientVehicle);
	}
	
	@PutMapping
	public Vehicle updateVehicle(@RequestBody Vehicle detachedVehicle)
	{
		return vehicleService.updateVehicleDetails(detachedVehicle);
	}
	
	@DeleteMapping("/{vehicleId}")
	public String deleteVehicle(@PathVariable Long vehicleId)
	{
		return vehicleService.deleteVehicleDetails(vehicleId);
	}	
	
	
}//End of VehicleController
