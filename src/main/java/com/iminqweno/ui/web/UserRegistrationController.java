package com.iminqweno.ui.web;


import com.iminqweno.ui.dto.UserRegistrationDTO;
import com.iminqweno.ui.servicesImpl.UserRegistrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "call this api when registering a user")
    @ApiResponse(responseCode = "201", description = "user created",content = {@Content(mediaType = "application/json")})
    @PostMapping("register")
    public ResponseEntity<UserRegistrationDTO> sendUserRegistrationMessage(@RequestBody @Validated UserRegistrationDTO userRegistrationDTO){
       return new ResponseEntity<UserRegistrationDTO>(userRegistrationService.sendMessageToUserRegistrationQ(userRegistrationDTO), HttpStatus.CREATED) ;
    }
}
