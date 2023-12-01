package com.TalentStreamApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TalentStreamApp.Entity.Job;
import com.TalentStreamApp.Service.SearchForJobService;

@RestController
public class ApplicantSearchForJobController {
	@Autowired
    private SearchForJobService jobSearchService;

    @GetMapping("/applicant/searchjobbyskillname/{applicantId}/jobs/{skillName}")
    public ResponseEntity<Page<Job>> searchJobsBySkillAndApplicant(
    		@PathVariable int applicantId,
            @PathVariable String skillName,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Job> jobs = jobSearchService.searchJobsBySkillAndApplicant(applicantId, skillName, pageable);

        if (jobs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(jobs);
    }
}
