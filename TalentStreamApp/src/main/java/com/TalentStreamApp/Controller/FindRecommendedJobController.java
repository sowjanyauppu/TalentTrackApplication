package com.TalentStreamApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.TalentStreamApp.Entity.Job;
import com.TalentStreamApp.ServiceImpl.FindRecommendedJobService;

@RestController
public class FindRecommendedJobController {
	
         @Autowired	
	    private final FindRecommendedJobService findJobService = null;
	    

	    @GetMapping("/findrecommendedjob/{applicantId}")
	    public List<Job> recommendJobsForApplicant(@PathVariable String applicantId) {
	    	long applicantid = Long.parseLong(applicantId);

	    	return findJobService.findJobsMatchingApplicantSkills(applicantid);
	    }
	}


