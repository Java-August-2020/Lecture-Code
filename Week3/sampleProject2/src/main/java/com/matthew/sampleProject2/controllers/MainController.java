package com.matthew.sampleProject2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String processInfo(@RequestParam(value="name") String name, @RequestParam("location") String location, @RequestParam("color") String color, Model viewModel) {
		viewModel.addAttribute("name", name);
		viewModel.addAttribute("location", location);
		viewModel.addAttribute("color", color);
		return "result.jsp";
	}
	
	@RequestMapping("/{color}")
	public String color(@PathVariable("color") String color, Model viewModel) {
		if(color.equals("black")) {
			viewModel.addAttribute("color", "#000000");
			viewModel.addAttribute("bgcolor", "black");
		} else if(color.equals("red")) {
			viewModel.addAttribute("color", "#ff0000");
			viewModel.addAttribute("bgcolor", "#red");
		} else {
			viewModel.addAttribute("color", "#ffffff");
			viewModel.addAttribute("bgcolor", "color not regonized");
		}		
		return "color.jsp";
	}
}
