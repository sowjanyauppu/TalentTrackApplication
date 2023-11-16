package com.TalentStreamApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TalentStreamApp.Entity.CompanyProfile;
import com.TalentStreamApp.Entity.Recruiter;

public interface CompanyProfileRepository extends JpaRepository<CompanyProfile, Long> {

	Recruiter findByEmail(String username);
    // You can add custom query methods here if needed {

}
