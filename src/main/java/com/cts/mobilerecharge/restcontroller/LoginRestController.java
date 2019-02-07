package com.cts.mobilerecharge.restcontroller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.mobilerecharge.bean.AuthenticationStatus;
import com.cts.mobilerecharge.bean.User;
import com.cts.mobilerecharge.bean.mobileAppException;
import com.cts.mobilerecharge.service.UserService;

	
	@RestController
	public class LoginRestController {
		private UserService userService;
		

		@Autowired
		public void setUserService(UserService userService) {
			this.userService = userService;
		}

		

		@PostMapping("/rest/authenticate")
		@ExceptionHandler({mobileAppException.class })
		public User authenticate( @RequestBody User user) {
		System.out.println("inside authenticate");
		System.out.println(user);
			String password = user.getPassword();
			String actualPassword = null;

			AuthenticationStatus status = new AuthenticationStatus();
			status.setAuthenticated(false);

			User actualUser = userService.getUser(user.getMobileNumber());
			if (actualUser != null) {
				actualPassword = actualUser.getPassword();
			}
			status.setAuthenticated(password.equals(actualPassword));
			
			if(status.isAuthenticated()){
				actualUser.setPassword(null);
				return actualUser;
			}else{
				return null;
			}
	
		}

	}


