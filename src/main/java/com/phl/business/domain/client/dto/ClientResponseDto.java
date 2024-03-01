package com.phl.business.domain.client.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClientResponseDto {

    private String uuid;

    private String firstName;


    private String lastName;

    private String email;

    private String mobileNumber;
}
