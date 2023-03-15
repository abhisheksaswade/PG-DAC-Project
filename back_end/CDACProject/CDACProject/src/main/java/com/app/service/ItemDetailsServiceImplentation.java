package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.ItemDetails;
import com.app.repository.ItemDetailsDao;

@Service
@Transactional
public class ItemDetailsServiceImplentation implements ItemDetailsService {

	
//*********************dependency injection****************************************************************************	
	@Autowired
	private ItemDetailsDao itemDetailsRepo;

	
//*********************method implementation****************************************************************************	
	@Override
	public List<ItemDetails> getAllItemDetailsDetails() {
		return itemDetailsRepo.findAll();
	}

	@Override
	public Optional<ItemDetails> getItemDetailsDetails(Long itemDetailsId) {
		return itemDetailsRepo.findById(itemDetailsId);
	}

	@Override
	public ItemDetails addItemDetailsDetails(ItemDetails transientItemDetails) {
		
		return itemDetailsRepo.save(transientItemDetails);
	}

	@Override
	public ItemDetails updateItemDetailsDetails(ItemDetails detachedItemDetails) {
		return itemDetailsRepo.save(detachedItemDetails);
	}

	@Override
	public String deleteItemDetailsDetails(Long itemDetailsId) {

		if(itemDetailsRepo.existsById(itemDetailsId))
		{
			itemDetailsRepo.deleteById(itemDetailsId);
			return "ItemDetails Sucessfully Deleted......";
		}

		return "ItemDetails Deletion Failed......";
	}
	
	
}//End of ItemDetailsServiceImplentation
