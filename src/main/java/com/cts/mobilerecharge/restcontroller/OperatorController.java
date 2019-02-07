package com.cts.mobilerecharge.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mobilerecharge.bean.Operator;
import com.cts.mobilerecharge.bean.mobileAppException;
import com.cts.mobilerecharge.service.OperatorService;
@RestController
@RequestMapping("/operator")
public class OperatorController {
	private OperatorService operatorService;
	@Autowired
	public void setOperatorService(OperatorService operatorService) {
		this.operatorService = operatorService;
	}
	@GetMapping("/list")
	public List<Operator> getOperator() throws mobileAppException {
		List<Operator> operators=operatorService.getOperators();
		for(Operator operator : operators)
		{
			System.out.println(operator);
		}
		return operators;
	}
}
