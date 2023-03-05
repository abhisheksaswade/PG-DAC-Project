package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.MyOrder;
import com.app.repository.MyOrderDao;

@Service
@Transactional
public class MyOrderServiceImplementation implements MyOrderService {


//*********************dependency injection****************************************************************************	
	@Autowired
	private MyOrderDao myOrderRepo;

	
//*********************method implementation****************************************************************************	
	@Override
	public List<MyOrder> getAllMyOrderDetails() {
		return myOrderRepo.findAll();
	}

	@Override
	public Optional<MyOrder> getMyOrderDetails(Long myOrderId) {
		return myOrderRepo.findById(myOrderId);
	}

	@Override
	public MyOrder addMyOrderDetails(MyOrder transientMyOrder) {
		return myOrderRepo.save(transientMyOrder);
	}

	@Override
	public MyOrder updateMyOrderDetails(MyOrder detachedMyOrder) {
		return myOrderRepo.save(detachedMyOrder);
	}

	@Override
	public String deleteMyOrderDetails(Long myOrderId) {

		if(myOrderRepo.existsById(myOrderId))
		{
			myOrderRepo.deleteById(myOrderId);
			return "User Sucessfully Deleted......";
		}

		return "User Deletion Failed......";
		
	}

	
}//End of MyOrderServiceImplementation
