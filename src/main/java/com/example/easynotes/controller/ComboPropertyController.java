package com.example.easynotes.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.ComboPropertyMaintainer;
import com.example.easynotes.repository.ComboMaintainerRepository;



@CrossOrigin(maxAge = 3600)
@RestController
public class ComboPropertyController {

	@Autowired
	private ComboMaintainerRepository comboMaintainerRepository;

	@GetMapping("/combomaintainer")
	public List<ComboPropertyMaintainer> getAllComboPropertyMaintainer() {
		return comboMaintainerRepository.findAll();
	}

	@GetMapping("/combomaintainerbypropertytype/{propertytype}")
	public List<ComboPropertyMaintainer> getAllComboPropertyMaintainer(
			@PathVariable(value = "propertyType") String propertyType) {
		return comboMaintainerRepository.findAllByPropertyType(propertyType);
	}

	@PostMapping("/combomaintainer")
	public ComboPropertyMaintainer createComboPropertyMaintainer(
			@Valid @RequestBody ComboPropertyMaintainer comboPropertyMaintainer) {
		return comboMaintainerRepository.save(comboPropertyMaintainer);
	}

	@GetMapping("/combomaintainer/{id}")
	public ComboPropertyMaintainer getComboPropertyMaintainerById(@PathVariable(value = "id") Long comboMaintainerId) {
		return comboMaintainerRepository.findById(comboMaintainerId)
				.orElseThrow(() -> new ResourceNotFoundException("ComboPropertyMaintainer", "id", comboMaintainerId));
	}

	@PutMapping("/combomaintainer/{id}")
	public ComboPropertyMaintainer updateComboPropertyMaintainer(@PathVariable(value = "id") Long comboMaintainerId,
			@Valid @RequestBody ComboPropertyMaintainer newComboPropertyMaintainer) {

		ComboPropertyMaintainer existingCodePropertyMaintainer = comboMaintainerRepository.findById(comboMaintainerId)
				.orElseThrow(() -> new ResourceNotFoundException("ComboPropertyMaintainer", "id", comboMaintainerId));

		existingCodePropertyMaintainer.setPropertyName(newComboPropertyMaintainer.getPropertyName());
		existingCodePropertyMaintainer.setPropertyType(newComboPropertyMaintainer.getPropertyType());

		ComboPropertyMaintainer updatedEmployee = comboMaintainerRepository.save(existingCodePropertyMaintainer);
		return updatedEmployee;
	}

	@DeleteMapping("/combomaintainer/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long comboMaintainerId) {
		ComboPropertyMaintainer employee = comboMaintainerRepository.findById(comboMaintainerId)
				.orElseThrow(() -> new ResourceNotFoundException("ComboPropertyMaintainer", "id", comboMaintainerId));
		comboMaintainerRepository.delete(employee);
		return ResponseEntity.ok().build();
	}

}
