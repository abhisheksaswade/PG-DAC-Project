package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.ItemDetails;
import com.app.entities.MyOrder;
import com.app.service.ItemDetailsService;
import com.app.service.MyOrderService;

@RestController
@RequestMapping("/itemdetails")
@CrossOrigin("http://localhost:3000/")
public class ItemDetailsController {
	
	
//*********************dependency injection****************************************************************************
	@Autowired
	private ItemDetailsService itemDetailsService;
	
//*********************method implementation***************************************************************************

	//GET
	@GetMapping
	public List<ItemDetails> getItemDetails()
	{
		return itemDetailsService.getAllItemDetailsDetails();
	}
	
	//GET BY ID
	@GetMapping("/{itemDetailsId}")
	public Optional<ItemDetails> getItemDetails(@PathVariable Long itemDetailsId)
	{
		return itemDetailsService.getItemDetailsDetails(itemDetailsId);
	}
	
	//INSERT
	@PostMapping
	public ItemDetails addItemDetails(@RequestBody ItemDetails transientItemDetails)
	{
		return itemDetailsService.addItemDetailsDetails(transientItemDetails);
	}
	
	//UPDATE
	@PutMapping
	public ItemDetails updateItemDetails(@RequestBody ItemDetails detachedItemDetails)
	{
		return itemDetailsService.updateItemDetailsDetails(detachedItemDetails);
	}
	
	//DELETE
	@DeleteMapping("/{itemDetailsId}")
	public String deleteItemDetails(@PathVariable Long itemDetailsId)
	{
		
		return itemDetailsService.deleteItemDetailsDetails(itemDetailsId);
	}
	
	
//*********************Custom method implementation for customer***************************************************************************
	@GetMapping("cart_items/{myOrderId}")
	public List<ItemDetails> getAllItems(@PathVariable Long myOrderId)
	{
		return itemDetailsService.getAllItemsByOrderId(myOrderId);
	}
	
}//End of ItemDetailsController
