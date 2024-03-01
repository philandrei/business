package com.phl.business.domain.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Builder
@Component
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {

    private String name;

    private String description;

    private int quantity;

    private BigDecimal price;
}
