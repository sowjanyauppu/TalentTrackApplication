package com.TalentStreamApp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.TalentStreamApp.DTO.NewPasswordRequest;
import com.TalentStreamApp.DTO.OtpVerification;
import com.TalentStreamApp.DTO.ResetPasswordRequest;
import com.TalentStreamApp.Entity.Applicant;
import com.TalentStreamApp.Entity.Recruiter;
import com.TalentStreamApp.Service.RecruiterInterface;
import com.TalentStreamApp.ServiceImpl.EmailService;
import com.TalentStreamApp.ServiceImpl.OtpService;

@RestController
public class JobRecruiterController {
	
	@Autowired
	RecruiterInterface recruiterService;
	
	@Autowired
	OtpService otpService;
	@Autowired
	EmailService emailService;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("recruiter/registration-send-otp")
    public ResponseEntity<String> sendOtp(@RequestBody ResetPasswordRequest request) {
        String userEmail = request.getEmail();
        Recruiter jobRecruiter = recruiterService.findByEmail(userEmail);

        if (jobRecruiter == null) {
           // return ResponseEntity.badRequest().body("Email is not registered.");
       String otp = otpService.generateOtp(userEmail);
            // Send OTP email using EmailService
            emailService.sendOtpEmail(userEmail, otp);
         //   otpVerificationMap.put(userEmail, true); // Mark OTP as verified
            return ResponseEntity.ok("OTP sent to your email.");
        }
        else {
        	 return ResponseEntity.badRequest().body("Email is already  registered.");
        }
    }
	
	@PostMapping("/recruiter/verifyotp")
    public ResponseEntity<String> verifyOtp( @RequestBody  OtpVerification verificationRequest

    ) {
        String otp=verificationRequest.getOtp();
        String email=verificationRequest.getEmail();
       // System.out.println(otp+email);

        if (otpService.validateOtp(email, otp)) {
            return ResponseEntity.ok("OTP verified successfully");
        } else {
            return ResponseEntity.badRequest().body("Incorrect OTP.");
        }

    }
	
	
	 @PostMapping("/recruiter/reset-password/{email}")
	    public ResponseEntity<String> setNewPassword(@RequestBody NewPasswordRequest request, @PathVariable String email) {
	        String newPassword = request.getNewPassword();
	        String confirmedPassword = request.getConfirmedPassword();
	        if (email == null) {
	            return ResponseEntity.badRequest().body("Email not found.");

	        }
	        Recruiter recruiter = recruiterService.findByEmail(email);
	        if (recruiter == null) {
	            return ResponseEntity.badRequest().body("User not found.");
	        }
	        if(!(newPassword.equals(confirmedPassword)))
	        {
	        	return ResponseEntity.badRequest().body("password not match");
	        }
	         // Encode the new password before saving
	         String encodedPassword = passwordEncoder.encode(newPassword);
	         recruiter.setPassword(encodedPassword);
	 
	         // Save the updated password
	         recruiterService.updatePassword(recruiter); 
	        return ResponseEntity.ok("Password reset was done successfully");
	    }

	
	@PostMapping("/recruiter/registration")
    public ResponseEntity<String> registerRecruiter(@RequestBody Recruiter recruiter) {
        return recruiterService.saveRecruiter(recruiter);
    }
}
