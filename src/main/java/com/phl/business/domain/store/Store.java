package com.phl.business.domain.store;

import com.phl.business.domain.product.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "StoreTbl")
@Data
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String name;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private List<Product> products;

}
