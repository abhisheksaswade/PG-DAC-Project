package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Image;
import com.app.repository.ImageDao;

@Service
@Transactional
public class ImageServiceImplementation implements ImageService {


//*********************dependency injection****************************************************************************	
	@Autowired
	private ImageDao imageRepo;

	
//*********************method implementation****************************************************************************	
	@Override
	public List<Image> getAllImageDetails() {
		return imageRepo.findAll();
	}

	@Override
	public Optional<Image> getImageDetails(Long imageId) {	
		return imageRepo.findById(imageId);
	}

	@Override
	public Image addImageDetails(Image transientImage) {
		return imageRepo.save(transientImage);
	}

	@Override
	public Image updateImageDetails(Image detachedImage) {
		return imageRepo.save(detachedImage);
	}

	@Override
	public String deleteImageDetails(Long imageId) {
		if(imageRepo.existsById(imageId))
		{
			imageRepo.deleteById(imageId);
			return "Image Sucessfully Deleted......";
		}

		return "Image Deletion Failed......";
	}
	
}//End of ImageServiceImplementation
