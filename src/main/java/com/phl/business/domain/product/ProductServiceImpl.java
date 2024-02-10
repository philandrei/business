package com.phl.business.domain.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.productDtoToProduct(productDto);
        productRepository.save(product);
        return productMapper.productToProductDto(product);
    }

    @Override
    public ProductDto updateProduct(String uuid,ProductDto productDto) {
        Product existingProduct = productRepository.findById(uuid).orElseThrow(NoSuchElementException::new);
        existingProduct.updateFrom(productDto);
        return productMapper.productToProductDto(existingProduct);
    }

    @Override
    public Product getOneProduct(String uuid) {
        return productRepository.findById(uuid).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String deleteProduct(String uuid) {
        productRepository.deleteById(uuid);
        return uuid;
    }
}
