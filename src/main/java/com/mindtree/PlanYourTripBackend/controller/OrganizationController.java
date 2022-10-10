package com.mindtree.PlanYourTripBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.PlanYourTripBackend.model.Organization;
import com.mindtree.PlanYourTripBackend.repository.OrganizationRepository;
import com.mindtree.PlanYourTripBackend.service.OrganizationService;

@RestController
public class OrganizationController {

	@Autowired
	private OrganizationRepository reppository;

	@Autowired
	private OrganizationService service;

	/* find all organization name */
	@GetMapping("/organization")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Organization> findAllOrganization() {
		return reppository.findAll();
	}

	/* find all organization by name */
	@PostMapping("/organization")
	@CrossOrigin(origins = "http://localhost:4200")
	public Organization getAllOrganizationByName(@RequestBody String name) {
		return service.findAllOrganizationByName(reppository.findAll(), name);
	}
}
