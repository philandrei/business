package com.phl.business.domain.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequestDto {

    private String username;

    private String password;
}
