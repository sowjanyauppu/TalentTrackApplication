package com.TalentStreamApp.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Recruiter {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long recruiterId;

	    @Column(nullable = false)
	    private String companyname;

	    @Column(nullable = false, unique = true)
	    private String mobilenumber;

	    @Column(nullable = false, unique = true)
	    private String email;

	    @Column(nullable = false)
	    private String password;
	    
	    @Column(nullable = false)
	    private String roles="ROLE_JOBRECRUITER"; // Add the role field
	    
	    
	    @OneToOne(mappedBy = "jobRecruiter")
	    private CompanyProfile companyProfile;
	    
	  @OneToMany( cascade = CascadeType.ALL)
	    private List<Job> jobs;
	    
	/*    @OneToMany( cascade = CascadeType.ALL)
	    private List<TeamMember> teamMembers;  
	    */

	    public Long getRecruiterId() {
			return recruiterId;
		}

		public void setRecruiterId(Long recruiterId) {
			this.recruiterId = recruiterId;
		}

		public String getCompanyname() {
			return companyname;
		}

		public void setCompanyname(String companyname) {
			this.companyname = companyname;
		}

		public String getMobilenumber() {
			return mobilenumber;
		}

		public void setMobilenumber(String mobilenumber) {
			this.mobilenumber = mobilenumber;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRoles() {
			return roles;
		}

		public void setRoles(String roles) {
			this.roles = roles;
		}

		

}
