package com.matthew.dogs.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.matthew.dogs.models.Dog;
import com.matthew.dogs.models.User;
import com.matthew.dogs.repositories.DogRepository;

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
	
	// Add Liker to the list of User in the Dog Model
	public void addLiker(User user, Dog dog) {
		// get the ArrayList of Likers from the Dog Model
		List<User> likers = dog.getLikers();
		// Add the user that liked the dogs
		likers.add(user);
		// Update the DB
		this.dRepo.save(dog);
	}
	
	// Remove Liker from the list of Users in the Dog Model
	public void removeLiker(User user, Dog dog) {
		// Retrieve list of likers from specific dog
		List<User> likers = dog.getLikers();
		// Remove the user that likes the dog
		likers.remove(user);
		// Update the DV
		this.dRepo.save(dog);
	}
	
}
