package com.okta.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Using generated security password: 4e74d58a-2237-4e63-a604-17e36e677b87
@Controller
public class HelloWorldController {
	
	@GetMapping({"/", "hello"})
    public String helloWorld(@RequestParam(required = false, defaultValue = "World") String name, Model model, Principal principal) {
        model.addAttribute("name", principal.getName());
        
        return "hello-world";
    }

}
