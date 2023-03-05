package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.entities.ItemDetails;

public interface ItemDetailsService {
	
	
//********************* standard method declaration*****************************************************************
	//GET ALL
	public List<ItemDetails> getAllItemDetailsDetails();
	
	//GET BY ID
	public Optional<ItemDetails> getItemDetailsDetails(Long itemDetailsId);
	
	//INSERT
	public ItemDetails addItemDetailsDetails(ItemDetails transientItemDetails);
	
	//UPDATE
	public ItemDetails updateItemDetailsDetails(ItemDetails detachedItemDetails);
	
	//DELETE
	public String deleteItemDetailsDetails(Long itemDetailsId);

}//End of ItemDetailsService
