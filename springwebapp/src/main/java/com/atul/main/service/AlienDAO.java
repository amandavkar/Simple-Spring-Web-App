package com.atul.main.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atul.main.entity.Alien;

public interface AlienDAO extends JpaRepository<Alien, Integer> {

	List<Alien> findByTech(String string);

	List<Alien> findByAidGreaterThan(int i);
	
	@Query("from Alien where tech = ?1 order by aname")
	List<Alien> findByTechSorted(String string);
}
