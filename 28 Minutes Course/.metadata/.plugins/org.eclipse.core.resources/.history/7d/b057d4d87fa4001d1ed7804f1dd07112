package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.in28minutes.springboot.myfirstwebapp.AuthenticationService;

@Controller
public class LoginController {
	

	private AuthenticationService authenticationService; //@Service annotation had to be added in authentication service class - works with component but service is more proper
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String gotoLoginPage() {
		return "login"; // coming from application.properties - fills in name between prefix and suffix 
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		
		if (authenticationService.authenticate(name, password)) {
			model.put("name", name);
			
			// Authentication
			// name - in28minutes
			// password - dummy
			
			// return welcome page if authentication is passed
			return "welcome"; // coming from application.properties - fills in name between prefix and suffix 
		}
		
		// else add the error message to the model to display in the login view
		model.put("errorMessage", "Invalid Credentials! Please try again.");
		return "login";
		
	}


}
