package com.TalentStreamApp.Service;

import org.springframework.http.ResponseEntity;

import com.TalentStreamApp.Entity.Recruiter;

public interface RecruiterInterface {
	public ResponseEntity<String> saveRecruiter(Recruiter recruiter);
	public Recruiter findByEmail(String userEmail);
	public Recruiter updatePassword(Recruiter recruiter);
}
