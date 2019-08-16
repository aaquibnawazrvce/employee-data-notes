package com.example.easynotes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.easynotes.model.ServicesRequest;

public interface ServiceRequestRepository extends JpaRepository<ServicesRequest,Long>{

}
