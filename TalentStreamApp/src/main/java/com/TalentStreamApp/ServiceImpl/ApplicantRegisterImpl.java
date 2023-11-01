package com.TalentStreamApp.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.TalentStreamApp.Entity.Applicant;
import com.TalentStreamApp.Repository.ApplicantRegisterRepository;
import com.TalentStreamApp.Service.ApplicantRegisterServiceInterface;


@Service
public class ApplicantRegisterImpl implements ApplicantRegisterServiceInterface {
	
	@Autowired
	ApplicantRegisterRepository applicantRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public ApplicantRegisterImpl(ApplicantRegisterRepository applicantRepository) {
		
		this.applicantRepository = applicantRepository;
	}

	public Applicant findByEmailAddress(String userEmail) {

		return applicantRepository.findByEmail(userEmail);

	}

	@Override
	public ResponseEntity<String> saveapplicant(Applicant applicant) {
		// TODO Auto-generated method stub
		
		     if (applicantRepository.existsByEmail(applicant.getEmail())) {
		         return ResponseEntity.badRequest().body("Email already registered");

		     }

		   	     applicant.setPassword(passwordEncoder.encode(applicant.getPassword()));
		        	     applicantRepository.save(applicant);
		     return ResponseEntity.ok("Applicant registered successfully");

		}

	}



