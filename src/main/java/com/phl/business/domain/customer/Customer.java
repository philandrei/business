package com.phl.business.domain.customer;

import com.phl.business.domain.store.Store;
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

    public Customer updateFrom(CustomerDto customerDto){
        this.firstName = customerDto.getFirstName();
        this.lastName = customerDto.getLastName();
        this.email = customerDto.getEmail();
        this.mobileNumber = customerDto.getMobileNumber();
        return this;
    }

}
