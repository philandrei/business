package com.phl.business.domain.product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductResponseDto {
    private String uuid;

    private String name;

    private String description;

    private int quantity;

    private BigDecimal price;
}
