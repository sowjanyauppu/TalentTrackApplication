package com.TalentStreamApp.Service;

import org.springframework.http.ResponseEntity;

import com.TalentStreamApp.Entity.Applicant;

public interface ApplicantRegisterServiceInterface {
	public Applicant findByEmailAddress(String userEmail);
	public ResponseEntity<String> saveapplicant(Applicant applicant);

}
