package com.TalentStreamApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TalentStreamApp.Entity.Recruiter;
@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter, Long> {

	Recruiter findByEmail(String email);
    // Additional query methods can be defined here if needed

	boolean existsByEmail(String email);	
	
	Recruiter findByRecruiterId(Long id); 

}
