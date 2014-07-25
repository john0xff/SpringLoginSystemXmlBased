package com.phoenixjcam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController
{
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminPage()
	{
		ModelAndView model = new ModelAndView();
		
		model.addObject("title", "Spring Security");
		model.addObject("message", "admin page");
		model.setViewName("admin");

		return model;
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public ModelAndView signUpPage()
	{
		ModelAndView model = new ModelAndView();
		
		model.setViewName("join");

		return model;
	}

	@RequestMapping(value = {"/login", "/"}, method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error, 
			@RequestParam(value = "logout", required = false) String logout)
	{
		ModelAndView model = new ModelAndView();
		if (error != null)
		{
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null)
		{
			model.addObject("msg", "You've been logged out successfully.");
		}
		
		model.setViewName("login");

		return model;
	}
}