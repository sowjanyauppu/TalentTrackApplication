package com.TalentStreamApp.Entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ApplicantProfile {
	@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int profileid;

	@Embedded

    private BasicDetails basicDetails;

 

    @Embedded

    private XClassDetails xClassDetails;

 

    @Embedded

    private IntermediateDetails intermediateDetails;

 

    @Embedded

    private GraduationDetails graduationDetails;
    
    @ManyToMany(fetch = FetchType.LAZY,cascade = {

            CascadeType.PERSIST,

            CascadeType.MERGE

        })

 

    @JoinTable(

            name = "applicant_profile_skills_required",

            joinColumns = @JoinColumn(name = "profileid"),

            inverseJoinColumns = @JoinColumn(name = "applicantskill_id") // This is the column in the other table

        )

    private Set<ApplicantSkills> skillsRequired=new HashSet<>();
    
    @ElementCollection

    private List<ExperienceDetails> experienceDetails;
    
    @OneToOne(cascade = CascadeType.ALL)

    @JoinColumn(name="applicantid", referencedColumnName = "id")

    private Applicant applicant;
    
    @Column(nullable = false)

    private String roles="ROLE_JOBAPPLICANT";

	public int getProfileid() {
		return profileid;
	}

	public void setProfileid(int profileid) {
		this.profileid = profileid;
	}

	public BasicDetails getBasicDetails() {
		return basicDetails;
	}

	public void setBasicDetails(BasicDetails basicDetails) {
		this.basicDetails = basicDetails;
	}

	public XClassDetails getxClassDetails() {
		return xClassDetails;
	}

	public void setxClassDetails(XClassDetails xClassDetails) {
		this.xClassDetails = xClassDetails;
	}

	public IntermediateDetails getIntermediateDetails() {
		return intermediateDetails;
	}

	public void setIntermediateDetails(IntermediateDetails intermediateDetails) {
		this.intermediateDetails = intermediateDetails;
	}

	public GraduationDetails getGraduationDetails() {
		return graduationDetails;
	}

	public void setGraduationDetails(GraduationDetails graduationDetails) {
		this.graduationDetails = graduationDetails;
	}

	public Set<ApplicantSkills> getSkillsRequired() {
		return skillsRequired;
	}

	public void setSkillsRequired(Set<ApplicantSkills> skillsRequired) {
		this.skillsRequired = skillsRequired;
	}

	public List<ExperienceDetails> getExperienceDetails() {
		return experienceDetails;
	}

	public void setExperienceDetails(List<ExperienceDetails> experienceDetails) {
		this.experienceDetails = experienceDetails;
	}

	public Applicant getApplicant() {
		return applicant;
	}

	public void setApplicant(Applicant applicant) {
		this.applicant = applicant;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
    
}
