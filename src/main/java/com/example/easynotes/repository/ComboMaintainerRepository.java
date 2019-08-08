package com.example.easynotes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.easynotes.model.ComboPropertyMaintainer;



public interface ComboMaintainerRepository extends JpaRepository<ComboPropertyMaintainer, Long>{
	
	public List<ComboPropertyMaintainer> findAllByPropertyType(String propertyType);
	

}
