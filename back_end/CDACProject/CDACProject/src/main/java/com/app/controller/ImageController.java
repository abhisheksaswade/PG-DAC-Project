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

import com.app.entities.Image;
import com.app.service.ImageService;

@RestController
@RequestMapping("/image")
public class ImageController {
	

//*********************dependency injection****************************************************************************	
	@Autowired
	private ImageService imageService;
	

//*********************method implementation****************************************************************************	
	@GetMapping
	public List<Image> getAllImages()
	{
		return imageService.getAllImageDetails();
	}
	
	@GetMapping("/{imageId}")
	public Optional<Image> getImage(@PathVariable Long imageId)
	{
		return imageService.getImageDetails(imageId);
	}
	
	@PostMapping
	public Image addImage(@RequestBody Image transientImage)
	{
		return imageService.addImageDetails(transientImage);
	}
	
	@PutMapping
	public Image updateImage(@RequestBody Image detachedImage)
	{
		return imageService.updateImageDetails(detachedImage);
	}
	
	@DeleteMapping("/{imageId}")
	public String deleteImage(@PathVariable Long imageId)
	{
		return imageService.deleteImageDetails(imageId);
	}

	
}//End of ImageController
