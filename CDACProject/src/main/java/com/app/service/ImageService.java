package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.Image;

public interface ImageService {
	
	
//********************* standard method declaration*****************************************************************
	//GET ALL
	public List<Image> getAllImageDetails();
	
	//GET BY ID
	public Optional<Image> getImageDetails(Long imageId);
	
	//INSERT
	public Image addImageDetails(Image transientImage);
	
	//UPDATE
	public Image updateImageDetails(Image detachedImage);
	
	//DELETE
	public String deleteImageDetails(Long imageId);
	
}//End of ImageService
