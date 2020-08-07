package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.persistance.entity.User;
import com.projectpl.safeapi.persistance.dto.UserDto;
import com.projectpl.safeapi.exceptions.UserAlreadyExistException;
import com.projectpl.safeapi.security.registration.OnRegistrationCompleteEvent;
import com.projectpl.safeapi.service.email.EmailService;
import com.projectpl.safeapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class DataController implements IDataController {

    @Autowired
    private EmailService emailService;


    @GetMapping("/home")
    String home(){
        return "Its working";
    }

    @GetMapping("/testMail")
    void testMail() {

        emailService.sendMail("safe_sashay_cloud_test@outlook.com", "test", "test test \n test test");

        emailService.sendPreConfiguredMail("Ho ho ho");

    }



}
