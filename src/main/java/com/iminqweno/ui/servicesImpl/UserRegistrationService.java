package com.iminqweno.ui.servicesImpl;

import com.iminqweno.ui.dto.UserRegistrationDTO;
import com.iminqweno.ui.services.UserRegistrationInterface;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserRegistrationService {

    private UserRegistrationInterface userRegistrationInterface;

    final JmsTemplate jmsTemplate;

    public UserRegistrationService(UserRegistrationInterface userRegistrationInterface, JmsTemplate jmsTemplate){
        this.userRegistrationInterface = userRegistrationInterface;

        this.jmsTemplate = jmsTemplate;
    }

    public void saveUserRegistration(UserRegistrationDTO userRegistrationDTO){
        jmsTemplate.convertAndSend("UserRegistration_Queue",userRegistrationDTO);
    }
}
