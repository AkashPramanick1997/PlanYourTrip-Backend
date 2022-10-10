package com.mindtree.PlanYourTripBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.PlanYourTripBackend.model.Hotel;
import com.mindtree.PlanYourTripBackend.repository.HotelRepository;

@RestController
public class HotelController {
	
	@Autowired
	private HotelRepository hotelRepository;
	
	/* Retrieve details of all hotels*/
	@GetMapping("/hotels")
	public List<Hotel> allHotels(){
		return hotelRepository.findAll();
	}

	
}
