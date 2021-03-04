package com.iminqweno.ui.services;


import com.iminqweno.ui.dto.UserRegistrationDTO;
import org.springframework.stereotype.Component;

@Component
public interface UserRegistrationInterface{
    void createUserRegistration(UserRegistrationDTO userRegistrationDTO);
}
