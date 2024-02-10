package com.phl.business.domain.product.mapper;

import com.phl.business.domain.product.dto.ProductRequestDto;
import com.phl.business.domain.product.dto.ProductResponseDto;
import com.phl.business.domain.product.model.Product;
import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
public class ProductMapper {

    public Product productDtoToProduct(ProductRequestDto productRequestDto) {
        Product product = Product.builder()
                                  .description(productRequestDto.getDescription())
                                  .name(productRequestDto.getName())
                                  .price(productRequestDto.getPrice())
                                  .quantity(productRequestDto.getQuantity())
                                  .build();
        return product;
    }

    public ProductRequestDto productToProductDto(Product product) {
        ProductRequestDto productRequestDto = ProductRequestDto.builder()
                                                      .description(product.getDescription())
                                                      .name(product.getName())
                                                      .price(product.getPrice())
                                                      .quantity(product.getQuantity())
                                                      .build();
        return productRequestDto;
    }

    public ProductResponseDto productToProductResponseDto(Product product) {
        ProductResponseDto productResponseDto = ProductResponseDto.builder()
                                                        .uuid(product.getUuid())
                                                        .description(product.getDescription())
                                                        .name(product.getName())
                                                        .price(product.getPrice())
                                                        .quantity(product.getQuantity())
                                                        .build();
        return productResponseDto;
    }
}
