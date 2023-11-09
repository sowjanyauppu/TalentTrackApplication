package com.TalentStreamApp.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TalentStreamApp.Entity.Applicant;
import com.TalentStreamApp.Entity.NewPasswordRequest;
import com.TalentStreamApp.Entity.OtpVerification;
import com.TalentStreamApp.Repository.ApplicantRegisterRepository;
import com.TalentStreamApp.Service.ApplicantRegisterServiceInterface;
import com.TalentStreamApp.ServiceImpl.ApplicantRegisterImpl;
import com.TalentStreamApp.ServiceImpl.EmailService;
import com.TalentStreamApp.ServiceImpl.OtpService;



@RestController
public class ApplicantRegisterController {
	
	@Autowired
	private ApplicantRegisterServiceInterface applicantRegisterService; // Inject the service
	
	@Autowired
	ApplicantRegisterRepository applicantRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private OtpService otpService;
	private Map<String, Boolean> otpVerificationMap = new HashMap<>();
	
	@PostMapping("/applicant/sendotp")
    public ResponseEntity<String> sendOtp(@RequestBody Applicant  request) {
        String userEmail = request.getEmail();
        Applicant applicant = applicantRegisterService.findByEmailAddress(userEmail);
        if (applicant == null) {     
            String otp = otpService.generateOtp(userEmail);
         	            emailService.sendOtpEmail(userEmail, otp);
 	            otpVerificationMap.put(userEmail, true);
 	            return ResponseEntity.ok("OTP sent to your email.");
        }

        else {
        	 return ResponseEntity.badRequest().body("Email is already  registered.");
        }
    }
	
	@PostMapping("/applicant/forgotpassword/sendotp")
    public ResponseEntity<String> ForgotsendOtp(@RequestBody Applicant  request) {
        String userEmail = request.getEmail();
        Applicant applicant = applicantRegisterService.findByEmailAddress(userEmail);
        if (applicant != null) {     
            String otp = otpService.generateOtp(userEmail);
         	            emailService.sendOtpEmail(userEmail, otp);
 	            otpVerificationMap.put(userEmail, true);
 	            System.out.println(otp);
 	            return ResponseEntity.ok("OTP sent successfully");
        }
        else {
        	 return ResponseEntity.badRequest().body("Email is not  registered."); 
        } 
    }

	
	 @PostMapping("/applicant/verifyotp")
	    public ResponseEntity<String> verifyOtp( @RequestBody  OtpVerification verificationRequest

	    ) {
	        String otp=verificationRequest.getOtp();
	        String email=verificationRequest.getEmail();
	        System.out.println(otp+email);

	        if (otpService.validateOtp(email, otp)) {
	            return ResponseEntity.ok("OTP verified successfully");
	        } else {
	            return ResponseEntity.badRequest().body("Incorrect OTP.");
	        }

	    }
	 
	 @PostMapping("/applicants/reset-password/{email}")
	    public ResponseEntity<String> setNewPassword(@RequestBody NewPasswordRequest request, @PathVariable String email) {
	        String newPassword = request.getNewPassword();
	        String confirmedPassword = request.getConfirmedPassword();
	        if (email == null) {
	            return ResponseEntity.badRequest().body("Email not found.");

	        }
	        Applicant applicant = applicantRegisterService.findByEmailAddress(email);
	        if (applicant == null) {
	            return ResponseEntity.badRequest().body("User not found.");
	        }
	        if(!(newPassword.equals(confirmedPassword)))
	        {
	        	return ResponseEntity.badRequest().body("password not match");
	        }
	         // Encode the new password before saving
	         String encodedPassword = passwordEncoder.encode(newPassword);
	         applicant.setPassword(encodedPassword);
	 
	         // Save the updated password
	         applicantRepository.save(applicant);
	        return ResponseEntity.ok("Password reset was done successfully");
	    }

	 
	 @PostMapping("/saveApplicant")
	    public ResponseEntity<String> register(@RequestBody Applicant applicant) {
	       return applicantRegisterService.saveapplicant(applicant);
	    }

}
