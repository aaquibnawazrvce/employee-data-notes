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
import com.example.easynotes.model.ContactUs;
import com.example.easynotes.repository.ContactUsRepository;

@CrossOrigin(maxAge = 3600)
@RestController
public class ContactUsController {

	@Autowired
	private ContactUsRepository contactUsRepository;

	@GetMapping("/contactUs")
	public List<ContactUs> getAllContacts() {
		return contactUsRepository.findAll();
	}

	@PostMapping("/contactUs")
	public ContactUs createContact(@Valid @RequestBody ContactUs contactUs) {
		return contactUsRepository.save(contactUs);
	}

	@GetMapping("/contactUs/{id}")
	public ContactUs getContactById(@PathVariable(value = "id") Long contactId) {
		return contactUsRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("ContactUs", "id", contactId));
	}

	@PutMapping("/contactUs/{id}")
	public ContactUs updateContact(@PathVariable(value = "id") Long contactId,
			@Valid @RequestBody ContactUs contactUsDetails) {

		ContactUs contactUs = contactUsRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("ContactUs", "id", contactId));
		contactUs.setPhoneNo(contactUsDetails.getPhoneNo());

		ContactUs updatedEmployee = contactUsRepository.save(contactUs);
		return updatedEmployee;
	}

	@DeleteMapping("/contactUs/{id}")
	public ResponseEntity<?> deleteContact(@PathVariable(value = "id") Long contactId) {
		ContactUs contactUs = contactUsRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("contactUs", "id", contactId));

		contactUsRepository.delete(contactUs);

		return ResponseEntity.ok().build();
	}

}
