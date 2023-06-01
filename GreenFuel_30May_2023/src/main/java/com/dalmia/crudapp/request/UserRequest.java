package com.dalmia.crudapp.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank
    @Email
    private String emailId;

    @NotBlank
    @Size(min = 4,max = 35)
    private String username;

    @NotBlank
    @Size(min = 5,max = 40)
    private String password;



}
