package com.diego.saez.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GreetingController {

	
	 @RequestMapping("/hola")
	  public String hola(Model modelo) {
	    	    
	    modelo.addAttribute("mensaje","hola desde thymeleaf");
	    return "hola";
	  }
	
}
