package com.cts.mobilerecharge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.mobilerecharge.bean.Transaction;
@Repository
public interface TransactionRepository  extends JpaRepository<Transaction, Integer>{
	List<Transaction> fetchAllTransactionDetail(@Param("userId") int userId);
}
