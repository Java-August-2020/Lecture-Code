package com.matthew.dogs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.dogs.models.Dog;
import com.matthew.dogs.models.Tag;
import com.matthew.dogs.services.DogService;
import com.matthew.dogs.services.TagService;

@Controller
public class DogController {
	@Autowired
	private DogService dService;
	@Autowired
	private TagService tService;
	
	@RequestMapping("/")
	public String index(Model viewModel) {
		List<Dog> dogs = this.dService.getAllPets();
		viewModel.addAttribute("allDogs", dogs);
		return "index.jsp";
	}
	
	
	@PostMapping("/")
	public String createNew(@Valid @ModelAttribute("dog") Dog newDog, BindingResult result) {
		if(result.hasErrors()) {
			return "new.jsp";
		} else {
			this.dService.createDog(newDog);
			return "redirect:/";
		}

	}
	
	//Antiquated Way
	// @RequestMapping(value="/", method=RequestMethod.POST)
	@PostMapping("/oldway")
	public String createOldWay(@RequestParam("name") String name, @RequestParam("breed") String breed, @RequestParam("age") int age, RedirectAttributes redirectAttr) {
		ArrayList<String> errors = new ArrayList<String>();
		if(name.equals("")) {
			errors.add("hey there, you forgot to add a name");
		}
		
		if(errors.size() > 0) {
			for(String e: errors) {
				redirectAttr.addFlashAttribute("errors", e);
			}
			return "redirect:/new";
		}
		this.dService.createDog(name, breed, age);
		return "redirect:/";
	}
	
	
	
	@RequestMapping("/new")
	public String create(@ModelAttribute("dog") Dog dog) {
		return "new.jsp";
	}
	
	@RequestMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("dog") Dog dog, @ModelAttribute("tag") Tag tag) {
		viewModel.addAttribute("dog", dService.getOneDog(id));		
		return "show.jsp";
	}
	
	@PostMapping("/tag")
	public String createTag(@Valid @ModelAttribute("tag") Tag tag, BindingResult result, Model viewModel) {
		Long dogId = tag.getDog().getId();
		if(result.hasErrors()) {
			viewModel.addAttribute("dog", dService.getOneDog(dogId));
			return "show.jsp";
		} else {
			this.tService.create(tag);
			return "redirect:/" + dogId;
		}
	}
}
