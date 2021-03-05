package com.iminqweno.ui.web;


import com.iminqweno.ui.dto.UserRegistrationDTO;
import com.iminqweno.ui.servicesImpl.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserRegistrationController {

    final UserRegistrationService userRegistrationService;

    /*User registration data saved to a jms queue */
    @PostMapping("register")
    public void sendUserRegistrationMessage(@RequestBody @Validated UserRegistrationDTO userRegistrationDTO){
        userRegistrationService.sendMessageToUserRegistrationQ(userRegistrationDTO);
    }
}
