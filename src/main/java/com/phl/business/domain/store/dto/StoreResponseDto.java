package com.phl.business.domain.store.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StoreResponseDto {
    private String uuid;
    private String name;
}
