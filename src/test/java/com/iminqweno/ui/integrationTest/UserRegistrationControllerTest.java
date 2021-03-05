package com.iminqweno.ui.integrationTest;


import com.iminqweno.ui.dto.UserRegistrationDTO;
import com.iminqweno.ui.web.UserRegistrationController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = UserRegistrationController.class)
public class UserRegistrationControllerTest {

    @LocalServerPort
    private int port;
    @Autowired
    TestRestTemplate testRestTemplate;


    @Test
    public void testSendUserRegistrationMessage(){
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO("d","g","c","");
        ResponseEntity<String> responseEntity = this.testRestTemplate
                .postForEntity("http://localhost:" + port + "/api/v1/register", userRegistrationDTO,String.class);
        assertEquals(201,responseEntity.getStatusCodeValue());
    }
}
