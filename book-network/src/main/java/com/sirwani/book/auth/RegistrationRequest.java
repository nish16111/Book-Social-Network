package com.sirwani.book.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {
    @NotEmpty(message = "Firstname can't be empty")
    @NotBlank(message = "Firstname can't be blank")
    private String firstname;
    @NotEmpty(message = "Lastname can't be empty")
    @NotBlank(message = "Lastname can't be blank")
    private String lastname;
    @NotEmpty(message = "Email can't be empty")
    @NotBlank(message = "Email can't be blank")
    @Email(message = "Email is not well formatted")
    private String email;
    @NotEmpty(message = "Password can't be empty")
    @NotBlank(message = "Password can't be blank")
    @Size(message = "Password should be at least 8 characters in length!")
    private String password;
}
