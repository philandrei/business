package com.phl.business.domain.product;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
public class ProductMapper {

    public Product productDtoToProduct(ProductDto productDto){
        Product product = Product.builder()
                                  .description(productDto.getDescription())
                                  .name(productDto.getName())
                                  .price(productDto.getPrice())
                                  .quantity(productDto.getQuantity())
                                  .build();
        return product;
    }

    public ProductDto productToProductDto(Product product){
        ProductDto productDto = ProductDto.builder()
                                        .description(product.getDescription())
                                        .name(product.getName())
                                        .price(product.getPrice())
                                        .quantity(product.getQuantity())
                                        .build();
        return productDto;
    }
}
