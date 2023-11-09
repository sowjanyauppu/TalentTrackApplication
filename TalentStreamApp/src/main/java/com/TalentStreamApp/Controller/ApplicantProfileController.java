package com.TalentStreamApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TalentStreamApp.Entity.Applicant;
import com.TalentStreamApp.Entity.ApplicantProfile;
import com.TalentStreamApp.Repository.ApplicantRegisterRepository;
import com.TalentStreamApp.Service.ApplicantProfileServiceInterface;
import com.TalentStreamApp.ServiceImpl.ApplicantProfileService;

@RestController
public class ApplicantProfileController {
	private final ApplicantProfileService applicantProfileService;
	private final ApplicantRegisterRepository applicantService;
	
	 @Autowired
	    public ApplicantProfileController(ApplicantProfileService applicantProfileService,ApplicantRegisterRepository applicantService) {
	        this.applicantProfileService = applicantProfileService;
			this.applicantService = applicantService;
	    }

	@PostMapping("applicant/createprofile/{applicantid}")
    public ResponseEntity<ApplicantProfile> createOrUpdateApplicantProfile(@PathVariable long applicantid,@RequestBody ApplicantProfile applicantProfile) {
    	 Applicant applicant = applicantService.getApplicantById(applicantid);
         if (applicant == null) {
             return ResponseEntity.notFound().build();
         }
         else
         {
        	 applicantProfile.setApplicant(applicant);
	   ApplicantProfile savedProfile = applicantProfileService.createOrUpdateApplicantProfile(applicantProfile);
        return ResponseEntity.ok(savedProfile);
         }
    }

}
