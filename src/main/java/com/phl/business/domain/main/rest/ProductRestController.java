package com.phl.business.domain.main.rest;

import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.main.service.ProductService;
import com.phl.business.domain.product.dto.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores/")
public class ProductRestController {

    @Autowired
    ProductService productService;

    @PostMapping("{storeId}/products")
    public ResponseEntity<RestResponse> addStoreProducts(@PathVariable String storeId,
                                                         @RequestBody List<ProductRequestDto> productRequestDtoList) {
        return productService.addProducts(storeId, productRequestDtoList);
    }

    @GetMapping("{storeId}/products")
    public ResponseEntity<RestResponse> getAllStoreProducts(@PathVariable String storeId) {
        return productService.getProducts(storeId);
    }

    @PutMapping("{storeId}/products/{productId}")
    public ResponseEntity<RestResponse> updateProduct(@PathVariable String storeId,
                                                    @PathVariable String productId,
                                                    @RequestBody ProductRequestDto productRequestDto){
        return productService.updateProduct(storeId,productId,productRequestDto);
    }

    @DeleteMapping("{storeId}/products/{productId}")
    public ResponseEntity<RestResponse> deleteProduct(@PathVariable String storeId,
                                                      @PathVariable String productId){
        return productService.deleteProduct(storeId,productId);
    }
}
