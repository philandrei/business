package com.phl.business.domain.store.model;

import com.phl.business.domain.product.model.Product;
import com.phl.business.domain.store.dto.StoreRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
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

    @OneToMany(mappedBy = "store",cascade = CascadeType.ALL)
    private List<Product> products;

    public Store updateFrom(StoreRequestDto storeRequestDto){
        this.name = storeRequestDto.getName();
        return this;
    }

}
