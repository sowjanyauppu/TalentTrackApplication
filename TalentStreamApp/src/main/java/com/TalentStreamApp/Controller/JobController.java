package com.TalentStreamApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TalentStreamApp.Entity.Job;
import com.TalentStreamApp.Entity.Recruiter;
import com.TalentStreamApp.Repository.RecruiterRepository;
import com.TalentStreamApp.Service.JobServiceInterface;

import jakarta.validation.Valid;

@RestController
public class JobController {
	@Autowired
	RecruiterRepository jobRecruiterRepository;
	
	@Autowired
	JobServiceInterface jobService;

	 @PostMapping("/recruiters/saveJob/{jobRecruiterId}")
	    public ResponseEntity<String> saveJob(@RequestBody @Valid Job job, @PathVariable Long jobRecruiterId) {
	        // Associate eligibility with the job
	        Recruiter jobRecruiter = jobRecruiterRepository.findByRecruiterId(jobRecruiterId);

	        if (jobRecruiter != null) {
	            // Associate the JobRecruiter with the CompanyProfile
	            job.setJobRecruiter(jobRecruiter);
	            // Save the CompanyProfile with the associated JobRecruiter
	            jobService.saveJob(job);
	            return ResponseEntity.status(HttpStatus.OK).body("Job saved successfully.");
	        } else {
	            // Handle the case where the JobRecruiter with the provided ID does not exist
	            // You can return an error response with a 404 Not Found status code
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("JobRecruiter with ID " + jobRecruiterId + " not found.");
	        }
	    }
	 
	 @GetMapping("/recruiters/viewJobs/{jobRecruiterId}")
	    public ResponseEntity<List<Job>> getJobsByRecruiter(@PathVariable Long jobRecruiterId) {
	        // You can add validation here to ensure the jobRecruiterId is valid.   

	 

	        List<Job> jobs = jobService.getJobsByRecruiter(jobRecruiterId);

	        if (jobs.isEmpty()) {
	            // If no jobs are found for the specified recruiter, you can return a not found response.
	            return ResponseEntity.notFound().build();
	        } else {
	            return ResponseEntity.ok(jobs);
	        }
	    }
}

