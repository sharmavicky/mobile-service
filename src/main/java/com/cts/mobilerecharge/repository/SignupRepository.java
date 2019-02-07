package com.cts.mobilerecharge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.mobilerecharge.bean.User;

public interface SignupRepository extends JpaRepository<User, Integer> {

}
