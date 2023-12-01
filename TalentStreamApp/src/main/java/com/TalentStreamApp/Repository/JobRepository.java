package com.TalentStreamApp.Repository;


import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.TalentStreamApp.Entity.Job;

public interface JobRepository extends JpaRepository<Job, Long> {

	@Query("SELECT DISTINCT j FROM Job j " +
	           "JOIN j.skillsRequired r " +
	           "WHERE LOWER(r.skillName) IN :skillNames")
	 List<Job> findBySkillsRequiredIgnoreCaseAndSkillNameIn(Set<String> skillNames);
	
	@Query("SELECT j FROM Job j WHERE j.jobRecruiter.id = :jobRecruiterId")  
	// :jobRecruiterId is used to denote a named parameter in the JPQL (Java Persistence Query Language) query. Named parameters in JPQL allow you to write more dynamic queries where values can be substituted at runtime.
    List<Job> findByJobRecruiterId(@Param("jobRecruiterId") Long jobRecruiterId);
	
	@Query("SELECT DISTINCT j FROM Job j JOIN j.skillsRequired s WHERE LOWER(s.skillName) = LOWER(:skillName)")
	Page<Job> findJobsBySkillName(@Param("skillName") String skillName, Pageable pageable);

}

