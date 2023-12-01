package com.TalentStreamApp.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TalentStreamApp.Entity.Applicant;
import com.TalentStreamApp.Entity.Job;
import com.TalentStreamApp.Entity.SavedJob;
import com.TalentStreamApp.Repository.ApplicantRegisterRepository;
import com.TalentStreamApp.Repository.JobRepository;
import com.TalentStreamApp.Repository.SavedJobRepository;
import com.TalentStreamApp.Service.SavedJobInterface;

@Service
public class SavedJobService implements SavedJobInterface {
	
	@Autowired
	ApplicantRegisterRepository applicantRepository;
	
	@Autowired
	JobRepository jobRepository;
	@Autowired
	SavedJobRepository savedJobRepository;

	@Override
	 public void saveJobForApplicant(long applicantId, long jobId) throws Exception {
        Applicant applicant = applicantRepository.findById(applicantId);
        Job job = jobRepository.findById(jobId).orElse(null);
        if(applicant ==null || job == null)
        	throw new Exception("Applicant ID or Job Id not found");
        
        else {
            if (!savedJobRepository.existsByApplicantAndJob(applicant, job)) {
                SavedJob savedJob = new SavedJob();
                savedJob.setApplicant(applicant);
                savedJob.setJob(job);
                savedJobRepository.save(savedJob);
            } else {
                throw new Exception("Job has already been saved by the applicant");
            }
        }
    }

}
