package com.iminqweno.ui.web;


import com.iminqweno.ui.dto.UserRegistrationDTO;
import com.iminqweno.ui.servicesImpl.UserRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserRegistrationController {

    final UserRegistrationService userRegistrationService;

    public UserRegistrationController(UserRegistrationService userRegistrationService) {
        this.userRegistrationService = userRegistrationService;
    }

    /*User registration data saved to a jms queue */
    @PostMapping("register")
    public void enqueueUserRegistartion(@RequestBody UserRegistrationDTO userRegistrationDTO){
        userRegistrationService.saveUserRegistration(userRegistrationDTO);
    }
}
