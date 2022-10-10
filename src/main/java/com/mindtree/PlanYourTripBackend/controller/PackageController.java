package com.mindtree.PlanYourTripBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.PlanYourTripBackend.model.Pack;
import com.mindtree.PlanYourTripBackend.repository.PackageRepository;
import com.mindtree.PlanYourTripBackend.service.PackageService;

@RestController
public class PackageController {

	@Autowired
	private PackageRepository repository;

	@Autowired
	private PackageService service;

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

	@GetMapping(value = "/hotels/packs")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Pack> getAllPackFromHotelId(@RequestParam int id) {
		return service.findPackByHotelId(id);
	}

}
