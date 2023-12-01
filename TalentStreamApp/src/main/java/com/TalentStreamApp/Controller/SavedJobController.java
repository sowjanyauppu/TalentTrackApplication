package com.TalentStreamApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TalentStreamApp.Service.SavedJobInterface;

@RestController
public class SavedJobController {
	
	@Autowired
	SavedJobInterface savedJobService;

	 @PostMapping("/applicants/savejob/{applicantId}/{jobId}")
	    public ResponseEntity<String> saveJobForApplicant(
	            @PathVariable long applicantId,
	            @PathVariable long jobId
	    ) {
	    	 try {
	             savedJobService.saveJobForApplicant(applicantId, jobId);
	             return ResponseEntity.ok("Job saved successfully for the applicant.");
	         } catch (Exception e) {
	             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	         }
	     }

}
