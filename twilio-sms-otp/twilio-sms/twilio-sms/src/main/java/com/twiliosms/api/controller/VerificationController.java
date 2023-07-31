package com.twiliosms.api.controller;
import com.twiliosms.api.payload.PhoneRequest;
import com.twiliosms.api.payload.VerificationRequest;
import com.twiliosms.api.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RestController;
@RestController
public class VerificationController {

    @Autowired
    private OTPService otpService;

    @PostMapping("/send-otp")
    public void sendOTP(@RequestBody PhoneRequest request) {
        String phoneNumber = request.getPhoneNumber();
        String otp = otpService.generateOTP();
        otpService.storeOTP(phoneNumber, otp);
        otpService.sendOTP(phoneNumber, otp);
    }

    @PostMapping("/verify-otp")
    public boolean verifyOTP(@RequestBody VerificationRequest request) {
        String phoneNumber = request.getPhoneNumber();
        String otp = request.getOtp();
        return otpService.verifyOTP(phoneNumber, otp);
    }
}
