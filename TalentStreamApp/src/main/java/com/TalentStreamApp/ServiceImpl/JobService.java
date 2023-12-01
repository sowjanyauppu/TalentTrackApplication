package com.TalentStreamApp.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TalentStreamApp.Entity.Job;
import com.TalentStreamApp.Repository.JobRepository;
import com.TalentStreamApp.Service.JobServiceInterface;

@Service
public class JobService implements JobServiceInterface {

	@Autowired
	JobRepository jobRepository;
	
	@Override
	public Job saveJob(Job job) {		
	        return jobRepository.save(job);
	    
	}

	@Override
	public List<Job> getJobsByRecruiter(Long jobRecruiterId) {
		// TODO Auto-generated method stub
	        // You need to implement the logic to retrieve jobs by recruiter ID.
	        // This depends on how your data is structured and your data access layer.
	        // Here's a simplified example assuming you have a method in the repository.
	        // You should implement this method in your repository.
	        // Replace "findByJobRecruiterId" with the actual method you use to retrieve jobs by recruiter ID.
	        List<Job> jobs = jobRepository.findByJobRecruiterId(jobRecruiterId);
	        return jobs;
	    
	    
	}

}
