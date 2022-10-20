package com.mindtree.PlanYourTripBackend.controller;

import java.util.List;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.PlanYourTripBackend.model.Pack;
import com.mindtree.PlanYourTripBackend.repository.HotelRepository;
import com.mindtree.PlanYourTripBackend.repository.PackageRepository;
import com.mindtree.PlanYourTripBackend.service.PackageService;

@RestController
public class PackageController {

	@Autowired
	private PackageRepository repository;

	@Autowired
	private PackageService service;
	
	@Autowired
	HotelRepository hotelRepository;

//	@GetMapping("/packages")
//	@CrossOrigin(origins = "http://localhost:4200")
//	public List<Pack> findAllPackage(){
//		return repository.findAll();
//	}

	@PostMapping("/packs")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Pack> returnSortedPackByCity(@RequestBody String city) {
		List<Pack> packs = service.listOfPackage(repository.findAll(), city);
		return packs;
	}
	
	@GetMapping(value = "/packbyid")
	@CrossOrigin(origins = "http://localhost:4200")
	public Pack returnPackById(@RequestParam int id) {
		return repository.findById(id).orElse(null);
	}

	@GetMapping(value = "/hotels/packs")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Pack> getAllPackFromHotelId(@RequestParam int id) {
		return service.findPackByHotelId(id);
	}
	
	@GetMapping(value = "/packs")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Pack>  getAllPack(){
		return repository.findAll();
	}
	
	@PostMapping("/addpack")
	@CrossOrigin(origins = "http://localhost:4200")
	public Pack createPackage(@RequestParam int id,@RequestBody Pack pack) {
		pack.setHotel(hotelRepository.findById(id).orElse(null));
		Pack p = repository.save(pack);
		return p;
	}

	@DeleteMapping("/deletePack")
	@CrossOrigin(origins = "http://localhost:4200")
	public void detelePack(@RequestParam int id) {
		repository.deleteById(id);
	}
	
}
