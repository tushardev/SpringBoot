package com.spring.mvc.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.mvc.model.Registration;

@Controller
public class RegistrationController {
	
	@GetMapping("registration")
	public String getRegistration(@ModelAttribute("registration") Registration registration) {
		
		return "registration";
	}
	
	@PostMapping("registration")
	public String addRegistration(@Valid @ModelAttribute("registration") Registration registration,
			BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Errors in the input");
			return "registration";
		}
		
		System.out.println("Input Name: " + registration.getName());
		return "redirect:registration";
	}

}


/*** Try returning view with and without "redirect"
 * It will clear the form to avoid re-submission of same POST request  */
