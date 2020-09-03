package com.matthew.dogs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.matthew.dogs.repositories.DogRepository;
import com.matthew.dogs.models.Dog;

@Service
public class DogService {
	private DogRepository dRepo;
	
	
	public DogService(DogRepository repo) {
		this.dRepo = repo;
	}
	
	// getAll
	public List<Dog> getAllPets() {
		return this.dRepo.findAll();
	}
	
	// getOne
	public Dog getOneDog(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	// createPet
	public Dog createDog(Dog newDog) {
		return this.dRepo.save(newDog);
	}
	
	// Create Pet overloaded from the frotnend
	public Dog createDog(String name, String breed, int age) {
		Dog newDog = new Dog(name, breed, age);
		return this.dRepo.save(newDog);
	}
	
	// updatePet
	public Dog updateDog(Long id, Dog updatedDog) {
		return this.dRepo.save(updatedDog);
	}
	
	public Dog updateDog(Dog updatedDog) {
		return this.dRepo.save(updatedDog);
	}
	
	// deletePet
	public void deletePet(Long id) {
		this.dRepo.deleteById(id);
	}
	
	
}
