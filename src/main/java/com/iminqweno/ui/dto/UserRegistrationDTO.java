package com.iminqweno.ui.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserRegistrationDTO {

    @NonNull
    @NotBlank(message = "first name cannot be empty")
    private String firstName;
    @NonNull
    @NotBlank(message = "last name cannot be empty")
    private String lastName;
    @NonNull
    @Size(max = 8)
    @Length(max = 20,message = "password cannot be more than 20 characters long")
    @NotBlank(message = "password cannot be empty")
    private String password;
    @NonNull
    @NotBlank(message = "username cannot be empty")
    @Email(message = "please enter a valid email")
    private String username;


}
