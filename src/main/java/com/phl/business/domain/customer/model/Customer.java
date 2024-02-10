package com.phl.business.domain.customer.model;

import com.phl.business.domain.customer.dto.CustomerRequestDto;
import com.phl.business.domain.store.model.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "CustomerTbl")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String firstName;


    private String lastName;

    private String email;

    private String mobileNumber;

    @OneToOne(fetch = FetchType.LAZY)
    private Store store;

    public Customer updateFrom(CustomerRequestDto customerRequestDto){
        this.firstName = customerRequestDto.getFirstName();
        this.lastName = customerRequestDto.getLastName();
        this.email = customerRequestDto.getEmail();
        this.mobileNumber = customerRequestDto.getMobileNumber();
        return this;
    }

}
