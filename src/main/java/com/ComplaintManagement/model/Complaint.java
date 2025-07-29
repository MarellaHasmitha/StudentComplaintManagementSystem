package com.ComplaintManagement.model;

import java.time.LocalDateTime;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String studentName;
	private String subject;
	
	@Column(length=1000)
	private String description;
	
	@Enumerated(EnumType.STRING)
	private ComplaintStatus status=ComplaintStatus.OPEN;
	
	private String priority;
	
	private LocalDateTime createdAt=LocalDateTime.now();
	
}
