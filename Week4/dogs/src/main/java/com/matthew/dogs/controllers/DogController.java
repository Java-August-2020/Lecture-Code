package com.matthew.dogs.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.matthew.dogs.models.Dog;
import com.matthew.dogs.models.Tag;
import com.matthew.dogs.models.Toy;
import com.matthew.dogs.models.User;
import com.matthew.dogs.services.DogService;
import com.matthew.dogs.services.TagService;
import com.matthew.dogs.services.UserService;
import com.matthew.dogs.validators.UserValidator;


@Controller
public class DogController {
	@Autowired
	private DogService dService;
	@Autowired
	private TagService tService;
	@Autowired
	private UserService uSerivce;
	@Autowired
	private UserValidator validator;
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "landing.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			// if there are validation errors, throw them back to the root route
			return "landing.jsp";
		}
		User newUser = this.uSerivce.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dogs";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uSerivce.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		
		User user = this.uSerivce.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/dogs";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/likes/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long dogId = id;
		User liker = this.uSerivce.getOneUser(userId);
		Dog likedDog = this.dService.getOneDog(dogId);
		this.dService.addLiker(liker, likedDog);
		return "redirect:/dogs";
	}
	
	@RequestMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		Long dogId = id;
		User unliker = this.uSerivce.getOneUser(userId);
		Dog likedDog = this.dService.getOneDog(dogId);
		this.dService.removeLiker(unliker, likedDog);
		return "redirect:/dogs";
	}
	
	@RequestMapping("/dogs")
	public String dogs(Model viewModel, HttpSession session) {
		Long userId = (Long)session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		User loggedUser = this.uSerivce.getOneUser(userId);
		List<Dog> dogs = this.dService.getAllPets();
		viewModel.addAttribute("allDogs", dogs);
		viewModel.addAttribute("user", loggedUser);
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
		Dog doggy = dService.getOneDog(id);
		List<Toy> dogtoys= doggy.getToys();
		viewModel.addAttribute("dog", dService.getOneDog(id));		
		for(Toy d: dogtoys) {
			System.out.println(d.getName());
		}
		return "show.jsp";
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public String updatePet(@Valid @ModelAttribute("dog") Dog updatedDog, BindingResult result, @ModelAttribute("tag") Tag tag) {
		if(result.hasErrors()) {
			return "show.jsp";
		} else {
			dService.updateDog(updatedDog);
			return "redirect:/";
		}
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
