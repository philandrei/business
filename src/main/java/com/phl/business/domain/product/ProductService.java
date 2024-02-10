package com.phl.business.domain.product;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(String uuid, ProductDto productDto);
    List<Product> getAllProducts();
    Product getOneProduct(String uuid);
    String deleteProduct(String uuid);

}
