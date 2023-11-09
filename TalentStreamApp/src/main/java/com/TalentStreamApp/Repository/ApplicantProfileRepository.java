package com.TalentStreamApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TalentStreamApp.Entity.ApplicantProfile;

public interface ApplicantProfileRepository extends JpaRepository<ApplicantProfile, Integer> {

ApplicantProfile findByApplicantId(long applicantid);
 
}
