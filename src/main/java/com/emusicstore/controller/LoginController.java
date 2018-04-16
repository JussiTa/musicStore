package com.emusicstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {



@RequestMapping(value="/login", method= RequestMethod.GET)

public String login(@RequestParam("error")String error,
		@RequestParam("logout")String logout,Model model) {
	
	if(error!=null)
		model.addAttribute("error", "Invalid username or password");
	
	if(logout!=null)
		model.addAttribute("logout", "Successfully logged out");
	return "login";
}



}
