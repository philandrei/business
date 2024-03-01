package com.phl.business.domain.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponseDto {

    private String uuid;

    private String username;
}
