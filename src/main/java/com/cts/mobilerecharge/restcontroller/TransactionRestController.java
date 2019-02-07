package com.cts.mobilerecharge.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mobilerecharge.bean.Transaction;
import com.cts.mobilerecharge.bean.mobileAppException;
import com.cts.mobilerecharge.service.TransactionService;

@RestController
@RequestMapping("/user")
public class TransactionRestController {
	
	private TransactionService transactionService;
	@Autowired
	public void setTransactionService(TransactionService  transactionService) {

		this. transactionService =  transactionService;
	}
	
	
	@GetMapping("/show/{userId}")
	 @ExceptionHandler({ mobileAppException.class })
	public List<Transaction> getTransaction(@PathVariable int userId) throws mobileAppException {
		return transactionService.getTransactions(userId);
		
		
	}
	

}
