package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.easynotes.model.ContactUs;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs,Long>{

}
