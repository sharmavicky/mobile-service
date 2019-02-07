package com.cts.mobilerecharge.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.cts.mobilerecharge.bean.Offers;

public interface OffersRepository extends JpaRepository<Offers, Integer>{
	//List<Offers> fetchAllEmployeeDetails();
	List<Offers> fetchOffersDetails(@Param("operatorId") int operatorId);

}
