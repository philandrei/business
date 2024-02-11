package com.phl.business.domain.store.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.phl.business.domain.client.model.Client;
import com.phl.business.domain.product.model.Product;
import com.phl.business.domain.store.dto.StoreRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "StoreTbl")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_uuid")
    private Client client;

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Product> products;

    public Store updateFrom(StoreRequestDto storeRequestDto){
        this.name = storeRequestDto.getName();
        return this;
    }

    public void addProduct(Product product){
        //to check
//        if(this.products == null){
//            this.products = new ArrayList<>();
//        }
        product.setStore(this);
        this.products.add(product);
    }

}
