package com.TalentStreamApp.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TalentStreamApp.Entity.CompanyProfile;
import com.TalentStreamApp.Repository.CompanyProfileRepository;
import com.TalentStreamApp.Service.CompanyProfileInterface;

@Service
public class CompanyProfileService implements CompanyProfileInterface {
	
	@Autowired
	CompanyProfileRepository companyProfileRepository;
	
	public CompanyProfile saveCompanyProfile(CompanyProfile companyProfile) {
        return companyProfileRepository.save(companyProfile);
    }
}
