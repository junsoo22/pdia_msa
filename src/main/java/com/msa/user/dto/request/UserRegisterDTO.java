package com.msa.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRegisterDTO {

    @Email
    @NotBlank
    private String email;
    @Size(min = 8, max = 16)
    private String passwd;

    @NotBlank
    private String name;
}
