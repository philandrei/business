package com.phl.business.domain.main.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationRequest {

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNumber;
}
