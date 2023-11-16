package com.TalentStreamApp.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.TalentStreamApp.Entity.Recruiter;
import com.TalentStreamApp.Repository.RecruiterRepository;
import com.TalentStreamApp.Service.RecruiterInterface;

@Service
public class RecruiterService implements RecruiterInterface {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
    RecruiterRepository recruiterRepository;

	@Override
	public ResponseEntity<String> saveRecruiter(Recruiter recruiter) {
		// TODO Auto-generated method stub
		 // Check if the email already exists in the database
        if (recruiterRepository.existsByEmail(recruiter.getEmail())) {
            return ResponseEntity.badRequest().body("Email already registered");
        }
        recruiter.setPassword(passwordEncoder.encode(recruiter.getPassword()));
        recruiterRepository.save(recruiter);
        return ResponseEntity.ok("Recruiter registered successfully");
	}

	@Override
	public Recruiter findByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return recruiterRepository.findByEmail(userEmail);
	}

	@Override
	public Recruiter updatePassword(Recruiter recruiter) {
		// TODO Auto-generated method stub
		
	              
	        return recruiterRepository.save(recruiter);
	}
	
	

}
