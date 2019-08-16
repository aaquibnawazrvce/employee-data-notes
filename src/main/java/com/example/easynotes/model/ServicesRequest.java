package com.example.easynotes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="SERVICESREQUEST")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class ServicesRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long serviceRequestId;
	
	
	public Long getServiceRequestId() {
		return serviceRequestId;
	}

	public void setServiceRequestId(Long serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getServiceDateStr() {
		return serviceDateStr;
	}

	public void setServiceDateStr(String serviceDateStr) {
		this.serviceDateStr = serviceDateStr;
	}

	public String getServiceTypeReq() {
		return serviceTypeReq;
	}

	public void setServiceTypeReq(String serviceTypeReq) {
		this.serviceTypeReq = serviceTypeReq;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@NotBlank
	private Date serviceDate;
	
	private transient String serviceDateStr;
	
	@NotBlank
	private String serviceTypeReq;
	
	@NotBlank
	private String subject;
	
	@NotBlank
	private String phoneNo;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String city;
	
	@NotBlank
	private String pinCode;
	
	@NotBlank
	private String country;
	
	@NotBlank
	private String state;
	
	@NotBlank
	private String desc;
}
