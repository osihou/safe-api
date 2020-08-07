package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.exceptions.UserAlreadyExistException;
import com.projectpl.safeapi.persistance.dto.UserDto;
import com.projectpl.safeapi.persistance.entity.User;
import com.projectpl.safeapi.persistance.entity.VerificationToken;
import com.projectpl.safeapi.security.registration.OnRegistrationCompleteEvent;
import com.projectpl.safeapi.service.user.IUserService;
import com.projectpl.safeapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Calendar;
import java.util.Locale;

@Controller
public class RegistrationController {

    @Autowired
    private IUserService service;

    @Autowired
    UserService userService;

    @Autowired
    private MessageSource messages;

    @GetMapping("/user/registration")
    public String showRegistrationForm(
            WebRequest request,
            Model model
    ) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registration";
    }

    @Autowired
    ApplicationEventPublisher eventPublisher;

    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDto userDto,
            HttpServletRequest request, Errors errors) {

        try {
            User registered = userService.registerNewUserAccount(userDto);

            String appUrl = request.getContextPath();
            eventPublisher.publishEvent(new OnRegistrationCompleteEvent(registered,
                    request.getLocale(), appUrl));
        } catch (UserAlreadyExistException uaeEx) {
            ModelAndView mav = new ModelAndView("registration", "user", userDto);
            mav.addObject("message", "An account for that username/email already exists.");
            return mav;
        } catch (RuntimeException ex) {
            return new ModelAndView("emailError", "user", userDto);
        }

        return new ModelAndView("successRegister", "user", userDto);
    }


    @GetMapping("/registrationConfirm")
    public String confirmRegistration(
            WebRequest request,
            Model model,
            @RequestParam("token") String token
    ) {

        Locale locale = request.getLocale();

        VerificationToken verificationToken = service.getVerificationToken(token);

        if (verificationToken == null) {
            String message = messages.getMessage("auth.message.invalidToken", null, locale);
            model.addAttribute("message", message);
            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }

        User user = verificationToken.getUser();

        Calendar cal = Calendar.getInstance();
        if ((verificationToken.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
            String messageValue = messages.getMessage("auth.message.expired", null, locale);
            model.addAttribute("message", messageValue);
            return "redirect:/badUser.html?lang=" + locale.getLanguage();
        }

        user.setEnabled(true);
        service.saveRegisteredUser(user);
        return "redirect:/login.html?lang=" + request.getLocale().getLanguage();
    }
}
