package com.matthew.dogs.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.dogs.models.Toy;
import com.matthew.dogs.services.DogService;
import com.matthew.dogs.services.ToyService;

@Controller
@RequestMapping("/toys")
public class ToyController {
	@Autowired
	private ToyService tService;
	@Autowired
	private DogService dService;
	
	// Page to Create a New Toy
	@RequestMapping("/new")
	public String createToy(@ModelAttribute("toy") Toy toy, Model viewModel) {
		viewModel.addAttribute("dogs", this.dService.getAllPets());
		return "toys/new.jsp";
	}
	
	// Process the new toy and insert into the database, Since we're using a new controller with a mapping layer of /toys/ to POST to the correct path, we leave the path empty, rather than putting "/"
	@PostMapping("")
	public String processToy(@Valid @ModelAttribute("toy") Toy toy, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dog", this.dService.getAllPets());
			return "toys/new.jsp";
		} else {
			this.tService.create(toy);
			return "redirect:/";
		}
	}
}
