package com.ComplaintManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ComplaintManagement.Service.ComplaintService;
import com.ComplaintManagement.model.Complaint;
import com.ComplaintManagement.model.ComplaintStatus;

@RestController
@RequestMapping("/api/complaints")
@CrossOrigin
public class Complaintcontroller {

	@Autowired
	private ComplaintService service;
	
	@PostMapping
	public Complaint submitComplaint(@RequestBody Complaint complaint)
	{
		return service.submitComplaint(complaint);
	}
	
	@GetMapping
	public List<Complaint> getAll(){
		return service.getAllComplaints();
	}
	
	@GetMapping("/open")
	public List<Complaint> getOpen(){
		return service.getOpenComplaints();
	}
	
	@GetMapping("/priority/{level}")
	public  List<Complaint> getByPriority(@PathVariable String level){
		return service.getByPriority(level.toUpperCase());
	}
	@PutMapping("/{id}/status")
	public Complaint updateStatus(@PathVariable Long id,@RequestParam ComplaintStatus status)
	{
		return service.updateComplaintStatus(id, status);
	}
	
}
