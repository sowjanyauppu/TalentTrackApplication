package com.TalentStreamApp.ServiceImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TalentStreamApp.Entity.ApplicantProfile;
import com.TalentStreamApp.Entity.ApplicantSkills;
import com.TalentStreamApp.Entity.Job;
import com.TalentStreamApp.Repository.ApplicantProfileRepository;
import com.TalentStreamApp.Repository.JobRepository;
@Service
public class FindRecommendedJobService {
	@Autowired
    private JobRepository jobRepository;

    @Autowired
    private ApplicantProfileRepository applicantRepository;
    
    @Autowired
    public FindRecommendedJobService(JobRepository jobRepository, ApplicantProfileRepository applicantRepository) {
        this.jobRepository = jobRepository;
        this.applicantRepository = applicantRepository;
    }
    public List<Job> findJobsMatchingApplicantSkills(long applicantid) {
    	
            ApplicantProfile applicantProfile = applicantRepository.findByApplicantId(applicantid);

            	Set<ApplicantSkills> applicantSkills = applicantProfile.getSkillsRequired();

        
          /*  Set<String> lowercaseApplicantSkillNames = applicantSkills.stream()
                    .map(skill -> skill.getSkillName().toLowerCase())
                    .collect(Collectors.toSet());  */

            //the above line is used to store the particular applicant skills into one set and all these converted into lowercase (Here they have used stream is one of the feature in java 8)
            
            //we can get this same by using collections also like below
            
               Set<String> lowercaseApplicantSkillNames = new HashSet<>();

    for (ApplicantSkills skill : applicantSkills) {
        lowercaseApplicantSkillNames.add(skill.getSkillName().toLowerCase());
    }

            // Query the database using a custom method for case-insensitive and partial matching
            List<Job> matchingJobs = jobRepository.findBySkillsRequiredIgnoreCaseAndSkillNameIn(lowercaseApplicantSkillNames);

            return matchingJobs;
        }
}
