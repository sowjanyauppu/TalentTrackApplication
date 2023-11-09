package com.TalentStreamApp.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TalentStreamApp.Entity.ApplicantProfile;
import com.TalentStreamApp.Repository.ApplicantProfileRepository;
import com.TalentStreamApp.Service.ApplicantProfileServiceInterface;
@Service
public class ApplicantProfileService implements ApplicantProfileServiceInterface {
	private final ApplicantProfileRepository applicantProfileRepository;
	
	@Autowired
    public ApplicantProfileService(ApplicantProfileRepository applicantProfileRepository) {
        this.applicantProfileRepository = applicantProfileRepository;
    }


	@Override
	public ApplicantProfile createOrUpdateApplicantProfile(ApplicantProfile applicantProfile) {
		// TODO Auto-generated method stub
		 return applicantProfileRepository.save(applicantProfile);
	}

}
