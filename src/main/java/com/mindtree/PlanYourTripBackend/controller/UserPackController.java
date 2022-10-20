package com.mindtree.PlanYourTripBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.PlanYourTripBackend.model.Pack;
import com.mindtree.PlanYourTripBackend.model.User;
import com.mindtree.PlanYourTripBackend.model.UserPackMapping;
import com.mindtree.PlanYourTripBackend.repository.PackageRepository;
import com.mindtree.PlanYourTripBackend.repository.UserPackRepository;
import com.mindtree.PlanYourTripBackend.repository.UserRepository;

@RestController
public class UserPackController {

	@Autowired
	private UserPackRepository userPackRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PackageRepository packageRepository;

	/* Add Package with user id*/
	@PostMapping(value = "/user-pack")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserPackMapping saveUserPackMapping(@RequestBody UserPackMapping userPackMapping, @RequestParam int userId,
			@RequestParam int packId) {
		UserPackMapping userPack = new UserPackMapping();
		userPack.setCheckIn(userPackMapping.getCheckIn());
		userPack.setCheckOut(userPackMapping.getCheckOut());
		userPack.setNumberOfPeople(userPackMapping.getNumberOfPeople());
		userPack.setNumberOfRooms(userPackMapping.getNumberOfRooms());
		User newUser = userRepository.findById(userId).orElse(null);
		userPack.setUser(newUser);
		Pack newPack = packageRepository.findById(packId).orElse(null);
		userPack.setPack(newPack);
		userPack.setTotalAmmount(userPackMapping.getNumberOfRooms()*newPack.getPackPrice());
		
		return userPackRepository.save(userPack);
	}
	
	/* fetch details of packages of a particular user*/
	@GetMapping(value = "/user-pack")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<UserPackMapping> getAllPackageDetailsByUserId(@RequestParam int userId){
		return userPackRepository.findUserPackMappingByUserUserId(userId);
	}
	
	
	/* fetch all pack details */
	@GetMapping(value = "/bookings")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<UserPackMapping> getAllBookings(){
		return userPackRepository.findAll();
	}
	
	@DeleteMapping(value = "/bookings")	
	@CrossOrigin(origins = "http://localhost:4200")
	public void deleteUserPack( @RequestParam int num ) {
		 userPackRepository.deleteById(num);
	}
	
	@GetMapping(value = "/booking")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserPackMapping getUserPackById(@RequestParam int id) {
		return userPackRepository.findById(id).orElseThrow();
	}
	
	/* update employee*/
	@PutMapping("updateBooking")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<UserPackMapping> updateDetails(@RequestBody UserPackMapping userPackMapping , @RequestParam int id){
		UserPackMapping mapping = userPackRepository.findById(id).orElseThrow();
		double packPrice = mapping.getPack().getPackPrice();
		mapping.setCheckIn(userPackMapping.getCheckIn());
		mapping.setCheckOut(userPackMapping.getCheckOut());
		mapping.setNumberOfPeople(userPackMapping.getNumberOfPeople());
		mapping.setNumberOfRooms(userPackMapping.getNumberOfRooms());
		double total = packPrice * userPackMapping.getNumberOfPeople();
		mapping.setTotalAmmount(total);
		UserPackMapping updateUserPackMapping =  userPackRepository.save(mapping);
		return ResponseEntity.ok(updateUserPackMapping);
	}
	
	
	
}
