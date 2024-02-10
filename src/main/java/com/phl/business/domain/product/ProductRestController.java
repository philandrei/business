package com.phl.business.domain.product;

import com.phl.business.domain.product.Product;
import com.phl.business.domain.product.ProductRequestDto;
import com.phl.business.domain.product.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {
    
    @Autowired
    ProductService productService;
    
    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productService.createProduct(productRequestDto);
    }

    @PutMapping("/{uuid}")
    public ProductResponseDto updateProduct(@PathVariable String uuid, @RequestBody ProductRequestDto productRequestDto){
        return productService.updateProduct(uuid, productRequestDto);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{uuid}")
    public Product getOneProduct(@PathVariable String uuid){
        return productService.getOneProduct(uuid);
    }

    @DeleteMapping("/{uuid}")
    public String deleteProduct(@PathVariable String uuid){
        return productService.deleteProduct(uuid);
    }
}
