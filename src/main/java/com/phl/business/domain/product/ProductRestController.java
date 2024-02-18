package com.phl.business.domain.product;

import com.phl.business.domain.product.dto.ProductRequestDto;
import com.phl.business.domain.product.dto.ProductResponseDto;
import com.phl.business.domain.product.model.Product;
import com.phl.business.domain.product.service.ProductCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductRestController {
    
    @Autowired
    ProductCrudService productCrudService;
    
    @PostMapping
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productCrudService.createProduct(productRequestDto);
    }

    @PutMapping("/{uuid}")
    public ProductResponseDto updateProduct(@PathVariable String uuid, @RequestBody ProductRequestDto productRequestDto){
        return productCrudService.updateProduct(uuid, productRequestDto);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productCrudService.getAllProducts();
    }

    @GetMapping("/{uuid}")
    public Product getOneProduct(@PathVariable String uuid){
        return productCrudService.getOneProduct(uuid);
    }

    @DeleteMapping("/{uuid}")
    public String deleteProduct(@PathVariable String uuid){
        return productCrudService.deleteProduct(uuid);
    }
}
