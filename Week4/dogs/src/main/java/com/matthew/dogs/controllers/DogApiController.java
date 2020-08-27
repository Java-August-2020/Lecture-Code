package com.matthew.dogs.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matthew.dogs.models.Dog;
import com.matthew.dogs.services.DogService;

@RestController
@RequestMapping("/api")
public class DogApiController {
	private DogService dService;
	public DogApiController(DogService service) {
		this.dService = service;
	}
	
	// Routes	
	@RequestMapping("/")
	public List<Dog> index(){
		return this.dService.getAllPets();
	}
	
	@RequestMapping("{id}")
	public Dog getDog(@PathVariable("id") Long id) {
		return this.dService.getOneDog(id);
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public Dog create(Dog newDog) {
		return this.dService.createDog(newDog);
	}
	
	@RequestMapping(value="/dog/update/{id}", method=RequestMethod.PUT)
	public Dog edit(@PathVariable("id") Long id, Dog updatedDog) {
		return this.dService.updateDog(id, updatedDog);
	}
	
	@RequestMapping("/dog/delete/{id}")
	public String removeDog(@PathVariable("id") Long id) {
		this.dService.deletePet(id);
		return id + " has been removed from the database";
	}
	
}
