package com.cts.mobilerecharge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.mobilerecharge.bean.Offers;
import com.cts.mobilerecharge.bean.Operator;
import com.cts.mobilerecharge.repository.OffersRepository;
import com.cts.mobilerecharge.repository.OperatorRepository;

@Service
public class OffersService {
	private  OffersRepository offersRepository;
	
	@Autowired
	public void setOperatorRepository(OffersRepository offersRepository)
	{
		this.offersRepository=offersRepository;
	}
	@Transactional
	public List<Offers> getOffers(int operatorId){
		
		return (List<Offers>) offersRepository.fetchOffersDetails(operatorId);
	}
	
}