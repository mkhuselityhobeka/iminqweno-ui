package com.iminqweno.ui.services;


import com.iminqweno.ui.dto.UserRegistrationDTO;

public interface UserRegistrationInterface{
    void sendMessageToUserRegistrationQ(UserRegistrationDTO userRegistrationDTO);
}
