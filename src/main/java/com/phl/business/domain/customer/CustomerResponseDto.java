package com.phl.business.domain.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerResponseDto {

    private String uuid;

    private String firstName;


    private String lastName;

    private String email;

    private String mobileNumber;
}
