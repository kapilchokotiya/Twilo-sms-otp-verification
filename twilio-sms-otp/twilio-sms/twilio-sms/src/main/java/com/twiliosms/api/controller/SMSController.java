package com.twiliosms.api.controller;

import com.twiliosms.api.payload.SMSRequest;
import com.twiliosms.api.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SMSController {

    private final TwilioService twilioService;

    @Autowired
    public SMSController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }
    //  http://localhost:8080/send-sms
    //  http://localhost:8080/send-sms
    //  http://localhost:8080/send-sms
    @PostMapping("/send-sms")
    public void sendSMS(@RequestBody SMSRequest request) {
        twilioService.sendSMS(request.getToPhoneNumber(), request.getMessageBody());
    }
}

