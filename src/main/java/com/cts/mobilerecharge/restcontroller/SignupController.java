package com.cts.mobilerecharge.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mobilerecharge.bean.User;
import com.cts.mobilerecharge.service.SignupService;


@RestController
public class SignupController {

	private SignupService signupService;

	@Autowired
	public void setSignupService(SignupService signupService) {
		this.signupService = signupService;
	}

	@PostMapping("/rest/signup")
	public void add(@RequestBody User user) {
		signupService.signup(user);
	}

}
