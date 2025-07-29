package com.ComplaintManagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ComplaintManagement.model.Complaint;
import com.ComplaintManagement.model.ComplaintStatus;
import com.ComplaintManagement.repository.ComplaintRepository;

@Service
public class ComplaintService {
	
	@Autowired
	private ComplaintRepository repo;
	
	
	public Complaint submitComplaint(Complaint complaint) {
		return repo.save(complaint);
	}
	
	public List<Complaint> getAllComplaints()
	{
		return repo.findAll();
	}
	
	public List<Complaint> getOpenComplaints()
	{
		return repo.findByStatus(ComplaintStatus.OPEN);
	}
   
	public List<Complaint> getByPriority(String priority)
	{
		return repo.findByPriority(priority);
	}
	
	public Complaint updateComplaintStatus(Long id,ComplaintStatus status)
	{
		Complaint complaint=repo.findById(id).orElseThrow(()->
		new RuntimeException("Complaint Not Found"));
		
		complaint.setStatus(status);
        return repo.save(complaint);
	}
}
