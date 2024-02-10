package com.phl.business.domain.product;

import com.phl.business.domain.store.Store;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "ProductTbl")
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


}
