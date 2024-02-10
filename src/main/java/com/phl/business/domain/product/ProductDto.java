package com.phl.business.domain.product;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDto {

    private String name;

    private String description;

    private int quantity;

    private BigDecimal price;
}
