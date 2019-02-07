package com.cts.mobilerecharge.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.mobilerecharge.bean.Transaction;
import com.cts.mobilerecharge.repository.TransactionRepository;

@Service
public class TransactionService {
	
private TransactionRepository  transactionRepository;
   
	
	@Autowired
	public void   setTransactionRepository( TransactionRepository  transactionRepository) {
		this.transactionRepository =transactionRepository;
	}

	
	@Transactional
	public List<Transaction> getTransactions(int userId) {
		return (List<Transaction>) transactionRepository.fetchAllTransactionDetail(userId);
	}
	
}

