package com.TalentStreamApp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TalentStreamApp.Entity.Applicant;
import com.TalentStreamApp.Entity.Job;
import com.TalentStreamApp.Entity.SavedJob;

public interface SavedJobRepository extends JpaRepository<SavedJob,Long> {
//	List<SavedJob> findByApplicantId(long applicantId);

	boolean existsByApplicantAndJob(Applicant applicant, Job job);
}
