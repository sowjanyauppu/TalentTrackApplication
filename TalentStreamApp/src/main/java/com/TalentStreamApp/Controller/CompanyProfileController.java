package com.TalentStreamApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TalentStreamApp.Entity.CompanyProfile;
import com.TalentStreamApp.Entity.Recruiter;
import com.TalentStreamApp.Repository.RecruiterRepository;
import com.TalentStreamApp.ServiceImpl.CompanyProfileService;

@RestController
public class CompanyProfileController {

	@Autowired
	RecruiterRepository jobRecruiterRepository;
	
	@Autowired
	CompanyProfileService companyProfileService;
	
	@PostMapping("/recruiters/company-profiles/{jobRecruiterId}")
    public ResponseEntity<String> createCompanyProfile(@RequestBody CompanyProfile companyProfile, @PathVariable Long jobRecruiterId) {
        Recruiter jobRecruiter = jobRecruiterRepository.findByRecruiterId(jobRecruiterId);

        if (jobRecruiter != null) {
            // Associate the JobRecruiter with the CompanyProfile
            companyProfile.setJobRecruiter(jobRecruiter);
            // Save the CompanyProfile with the associated JobRecruiter
            companyProfileService.saveCompanyProfile(companyProfile);
            return ResponseEntity.status(HttpStatus.OK).body("CompanyProfile saved successfully.");
        } else {
            // Handle the case where the JobRecruiter with the provided ID does not exist
            // You can return an error response with a 404 Not Found status code
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("JobRecruiter with ID " + jobRecruiterId + " not found.");
        }
    }

}
