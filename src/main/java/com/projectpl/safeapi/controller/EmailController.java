package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

//    @Autowired
//    private EmailService emailService;


    @GetMapping("/test_mail")
    String testMail() {
        //emailService.sendMail();
        //emailService.sendPreConfiguredMail();
        return "Email sent";

    }
}
