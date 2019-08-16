package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.Testimonial;

@Repository
public interface TestimonialRepository extends JpaRepository<Testimonial,Long>{

}
