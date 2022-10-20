package com.mindtree.PlanYourTripBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.PlanYourTripBackend.model.Hotel;
import com.mindtree.PlanYourTripBackend.model.OrganizationHotelMapping;
import com.mindtree.PlanYourTripBackend.repository.HotelRepository;
import com.mindtree.PlanYourTripBackend.repository.OrganizationHotelRepository;
import com.mindtree.PlanYourTripBackend.repository.OrganizationRepository;

@RestController
public class HotelController {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Autowired
	private OrganizationHotelRepository organizationHotelRepository;
	
	/* Retrieve details of all hotels*/
	@GetMapping("/hotels")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Hotel> allHotels(){
		return hotelRepository.findAll();
	}
	
	@PostMapping("/addhotel")
	@CrossOrigin(origins = "http://localhost:4200")
	public Hotel createHotel(@RequestParam int id,@RequestBody Hotel hotel) {
		Hotel h = hotelRepository.save(hotel);
		OrganizationHotelMapping oh = new OrganizationHotelMapping();
		oh.setHotel(h);
		oh.setOrganization(organizationRepository.findById(id).orElse(null));
		organizationHotelRepository.save(oh);
		return h;
	}

	
}
