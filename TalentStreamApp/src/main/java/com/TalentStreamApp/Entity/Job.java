package com.TalentStreamApp.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;

@Entity
public class Job {
	
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    @Column(nullable = false)
	    private String jobTitle;	 
		

		@Column(nullable = false)

	    private int minimumExperience;

	  
	@Column(nullable = false)
	    private int maximumExperience;

	 
	    @Column(nullable = false)
	    private double maxSalary;
	    
	    @Column(nullable = false)
	    private double minSalary;
	 
	   
		@Column(nullable = false)
	    private String location;

	    @Column(nullable = false)
	    private String employeeType;

	 
	    @Column(nullable = false)
	    private String industryType;
	 
	    @Column(nullable = false)
	    private String minimumQualification;

	 
	    @Column(nullable = false)
	    private String specialization;

	    	 	    
	    private String jobHighlights;
	    

	    @Column(nullable = false, length = 2000)

	    private String description;

	 

	    @Lob

	    @Column

	    private byte[] uploadDocument; // Use byte[] to store the file content

	 

	 	
}
