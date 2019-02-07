package com.cts.mobilerecharge.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cts.mobilerecharge.bean.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findBymobileNumber(String mobileNumber);

}