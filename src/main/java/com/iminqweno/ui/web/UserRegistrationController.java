package com.iminqweno.ui.web;


import com.iminqweno.ui.dto.UserRegistrationDTO;
import com.iminqweno.ui.servicesImpl.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserRegistrationDTO> sendUserRegistrationMessage(@RequestBody @Validated UserRegistrationDTO userRegistrationDTO){
       return new ResponseEntity<UserRegistrationDTO>(userRegistrationService.sendMessageToUserRegistrationQ(userRegistrationDTO), HttpStatus.CREATED) ;
    }
}
