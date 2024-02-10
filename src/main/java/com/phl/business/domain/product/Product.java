package com.phl.business.domain.product;

import com.phl.business.domain.store.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ProductTbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    private String uuid;

    private String name;

    private String description;

    private int quantity;

    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "store_uuid")
    private Store store;

    public Product updateFrom(ProductRequestDto productRequestDto){
        this.name = productRequestDto.getName();
        this.description = productRequestDto.getDescription();
        this.price = productRequestDto.getPrice();
        this.quantity = productRequestDto.getQuantity();
        return this;
    }


}
