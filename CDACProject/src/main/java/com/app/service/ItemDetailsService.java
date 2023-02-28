package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.ItemDetails;

public interface ItemDetailsService {
	
	public List<ItemDetails> getAllItemDetailsDetails();
	
	public Optional<ItemDetails> getItemDetailsDetails(Long itemDetailsId);
	
	public ItemDetails addItemDetailsDetails(ItemDetails transientItemDetails);
	
	public ItemDetails updateItemDetailsDetails(ItemDetails detachedItemDetails);
	
	public String deleteItemDetailsDetails(Long itemDetailsId);

}//ItemDetailsService
