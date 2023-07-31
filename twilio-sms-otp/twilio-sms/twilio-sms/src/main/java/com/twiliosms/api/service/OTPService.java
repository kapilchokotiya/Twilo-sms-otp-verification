package com.twiliosms.api.service;import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OTPService {

    @Autowired
    private TwilioService twilioService;

    private static final int OTP_LENGTH = 6;
    private Map<String, String> otpMap = new HashMap<>();

    public String generateOTP() {
        Random random = new Random();
        int otp = random.nextInt((int) Math.pow(10, OTP_LENGTH));
        return String.format("%0" + OTP_LENGTH + "d", otp);
    }

    public void sendOTP(String phoneNumber, String otp) {
        String messageBody = "Your OTP for verification is: " + otp;
        twilioService.sendSMS(phoneNumber, messageBody);
    }
// verifyOTP
    //new
    public   boolean verifyOTP(String phoneNumber, String otp) {
        if (otpMap.containsKey(phoneNumber) && otpMap.get(phoneNumber).equals(otp)) {
            otpMap.remove(phoneNumber);
            return true;
        }
        return false;
    }

    public void storeOTP(String phoneNumber, String otp) {
        otpMap.put(phoneNumber, otp);
    }
}
