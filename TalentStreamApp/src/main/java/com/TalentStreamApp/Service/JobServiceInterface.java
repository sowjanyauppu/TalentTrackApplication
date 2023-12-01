package com.TalentStreamApp.Service;

import java.util.List;

import com.TalentStreamApp.Entity.Job;

public interface JobServiceInterface {
	public Job saveJob(Job job); 
	public List<Job> getJobsByRecruiter(Long jobRecruiterId);
}
