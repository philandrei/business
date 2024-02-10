package com.phl.business.domain.product;

import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto productRequestDto);
    ProductResponseDto updateProduct(String uuid, ProductRequestDto productRequestDto);
    List<Product> getAllProducts();
    Product getOneProduct(String uuid);
    String deleteProduct(String uuid);

}
