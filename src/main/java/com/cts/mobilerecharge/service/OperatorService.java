package com.cts.mobilerecharge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.mobilerecharge.bean.Operator;
import com.cts.mobilerecharge.repository.OperatorRepository;

@Service
public class OperatorService {
	private  OperatorRepository operatorRepository;
	@Autowired
	public void setOperatorRepository(OperatorRepository operatorRepository)
	{
		this.operatorRepository=operatorRepository;
	}
	@Transactional
	public List<Operator> getOperators(){
		
		return (List<Operator>) operatorRepository.findAll();
	}
	
}
