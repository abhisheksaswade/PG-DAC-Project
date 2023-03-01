package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.Image;
import com.app.entities.Product;
import com.app.repository.ImageDao;
import com.app.repository.ProductDao;

@Service
@Transactional
public class ImageServiceImplementation implements ImageService {


//*********************dependency injection****************************************************************************	
	@Autowired
	private ImageDao imageRepo;
	
	@Autowired
	private ProductDao productRepo;

	
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
		
		//getting productId 
		Long productId= transientImage.getProduct().getId();
		
		//getting persistent Product
		Optional<Product> persistentProduct= productRepo.findById(productId);
		
		//to avoid lazy initialization
		persistentProduct.get().getProductName();
		
		//getting imageList & binding
		List<Image> imageList = persistentProduct.get().getImage();
		imageList.add(transientImage);
		persistentProduct.get().setImage(imageList);
		
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
