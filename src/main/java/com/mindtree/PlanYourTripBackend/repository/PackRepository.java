package com.mindtree.PlanYourTripBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.PlanYourTripBackend.model.Pack;

@Repository
public interface PackRepository extends JpaRepository<Pack, Integer>{

}
