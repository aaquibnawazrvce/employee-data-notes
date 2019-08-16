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
import com.example.easynotes.model.Testimonial;
import com.example.easynotes.repository.TestimonialRepository;

@CrossOrigin(maxAge = 3600)
@RestController
public class TestimonialController {

	@Autowired
	private TestimonialRepository testimonialRepository;
	
	  @GetMapping("/testimonial")
	    public List<Testimonial> getAllTestimonials() {
	        return testimonialRepository.findAll();
	    }

	    @PostMapping("/testimonial")
	    public Testimonial createTestimonial(@Valid @RequestBody Testimonial testimonial) {
	        return testimonialRepository.save(testimonial);
	    }

	    @GetMapping("/testimonial/{id}")
	    public Testimonial getTestimonialById(@PathVariable(value = "id") Long empId) {
	        return testimonialRepository.findById(empId)
	                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", empId));
	    }

	    @PutMapping("/testimonial/{id}")
	    public Testimonial updateTestimonial(@PathVariable(value = "id") Long empId,
	                                           @Valid @RequestBody Testimonial testimonialDetails) {

	    	Testimonial testimonial = testimonialRepository.findById(empId)
	                .orElseThrow(() -> new ResourceNotFoundException("Testimonial", "id", empId));
	    	testimonial.setStatus(testimonialDetails.getStatus());
	    	
	        Testimonial updatedEmployee = testimonialRepository.save(testimonial);
	        return updatedEmployee;
	    }

	    @DeleteMapping("/testimonial/{id}")
	    public ResponseEntity<?> deletTestimonial(@PathVariable(value = "id") Long empId) {
	    	Testimonial employee = testimonialRepository.findById(empId)
	                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", empId));

	    	testimonialRepository.delete(employee);

	        return ResponseEntity.ok().build();
	    }
}
