package com.cts.mobilerecharge.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mobilerecharge.bean.Offers;
import com.cts.mobilerecharge.bean.mobileAppException;
import com.cts.mobilerecharge.service.OffersService;

@RestController

public class OffersController {
	private OffersService offersService;
	
	@Autowired
	public void setOffersService(OffersService offersService){
		this.offersService=offersService;
	}
	@GetMapping("/offers/list/{operatorId}")
	public List<Offers> getOffer(@PathVariable int operatorId) throws mobileAppException{
		return offersService.getOffers(operatorId);
	}
	

}
