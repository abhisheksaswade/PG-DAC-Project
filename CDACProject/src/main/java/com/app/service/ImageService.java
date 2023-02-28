package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Image;

public interface ImageService {

	public List<Image> getAllImageDetails();
	
	public Optional<Image> getImageDetails(Long imageId);
	
	public Image addImageDetails(Image transientImage);
	
	public Image updateImageDetails(Image detachedImage);
	
	public String deleteImageDetails(Long imageId);
	
}//End of ImageService
