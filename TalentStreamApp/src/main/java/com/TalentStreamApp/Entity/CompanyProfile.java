package com.TalentStreamApp.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class CompanyProfile {
	@Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String companyName;

    private String website;

    private String phoneNumber;

    private String email;

    private String headOffice;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "job_recruiter_id", referencedColumnName = "recruiterId")
    private Recruiter jobRecruiter;

	public Recruiter getJobRecruiter() {
		return jobRecruiter;
	}

	public void setJobRecruiter(Recruiter jobRecruiter) {
		this.jobRecruiter = jobRecruiter;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeadOffice() {
		return headOffice;
	}

	public void setHeadOffice(String headOffice) {
		this.headOffice = headOffice;
	}

}
