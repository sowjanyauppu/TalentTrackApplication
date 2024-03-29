package com.TalentStreamApp.Service;


import java.util.Collections;
import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.TalentStreamApp.Entity.ApplicantProfile;
import com.TalentStreamApp.Entity.Job;
import com.TalentStreamApp.Repository.ApplicantProfileRepository;
import com.TalentStreamApp.Repository.JobRepository;

@Service
public class SearchForJobService {
	@Autowired
    private ApplicantProfileRepository applicantProfileRepository;

    @Autowired
    private JobRepository jobRepository;

    public Page<Job> searchJobsBySkillAndApplicant(int applicantId, String skillName, Pageable pageable) {
        Optional<ApplicantProfile> applicantOptional = applicantProfileRepository.findById(applicantId);
        
        if (applicantOptional.isPresent()) {
           return jobRepository.findJobsBySkillName(skillName, pageable);
        } else {
          List<Job> emptyJobList = Collections.emptyList();
          return new PageImpl<>(emptyJobList, pageable, 0);
        }
    }
}
