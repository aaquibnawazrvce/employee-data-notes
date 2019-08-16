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
import com.example.easynotes.model.ServicesRequest;
import com.example.easynotes.repository.ServiceRequestRepository;

@CrossOrigin(maxAge = 3600)
@RestController
public class ServiceRequestController {

	@Autowired
	private ServiceRequestRepository serviceRequestRepository;

	@GetMapping("/serviceReq")
	public List<ServicesRequest> getAllServices() {
		return serviceRequestRepository.findAll();
	}

	@PostMapping("/serviceReq")
	public ServicesRequest createServiceReq(@Valid @RequestBody ServicesRequest contactUs) {
		return serviceRequestRepository.save(contactUs);
	}

	@GetMapping("/serviceReq/{id}")
	public ServicesRequest getServiceReqById(@PathVariable(value = "id") Long contactId) {
		return serviceRequestRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("ServiceRequest", "id", contactId));
	}

	@PutMapping("/serviceReq/{id}")
	public ServicesRequest updateServiceReq(@PathVariable(value = "id") Long contactId,
			@Valid @RequestBody ServicesRequest serviceReqDetails) {

		ServicesRequest serviceReq = serviceRequestRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("ServiceRequest", "id", contactId));
		serviceReq.setPhoneNo(serviceReqDetails.getPhoneNo());
		serviceReq.setAddress(serviceReqDetails.getAddress());
		serviceReq.setCity(serviceReqDetails.getCity());
		serviceReq.setCountry(serviceReqDetails.getCountry());
		serviceReq.setDesc(serviceReqDetails.getDesc());
		serviceReq.setEmail(serviceReqDetails.getEmail());
		serviceReq.setPinCode(serviceReqDetails.getPinCode());
		serviceReq.setState(serviceReqDetails.getState());
		serviceReq.setSubject(serviceReqDetails.getSubject());
		ServicesRequest updatedServiceRequest = serviceRequestRepository.save(serviceReq);
		return updatedServiceRequest;
	}

	@DeleteMapping("/serviceReq/{id}")
	public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long contactId) {
		ServicesRequest contactUs = serviceRequestRepository.findById(contactId)
				.orElseThrow(() -> new ResourceNotFoundException("ServiceRequest", "id", contactId));

		serviceRequestRepository.delete(contactUs);

		return ResponseEntity.ok().build();
	}

}
