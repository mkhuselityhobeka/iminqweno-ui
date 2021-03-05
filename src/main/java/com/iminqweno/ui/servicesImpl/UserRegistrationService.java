package com.iminqweno.ui.servicesImpl;

import com.iminqweno.ui.config.JmsMessageConverterConfig;
import com.iminqweno.ui.dto.UserRegistrationDTO;
import com.iminqweno.ui.services.UserRegistrationInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistrationService implements UserRegistrationInterface{

    final JmsTemplate jmsTemplate;

    @Override
    public UserRegistrationDTO sendMessageToUserRegistrationQ(UserRegistrationDTO userRegistrationDTO) {
        jmsTemplate.convertAndSend(JmsMessageConverterConfig.UserRegistration_Queue,userRegistrationDTO);
        return userRegistrationDTO;
    }
}
