package com.phl.business.domain.customer;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto {

    private String firstName;

    private String lastName;

    private String email;

    private String mobileNumber;

}
