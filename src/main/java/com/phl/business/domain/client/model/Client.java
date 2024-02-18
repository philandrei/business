package com.phl.business.domain.client.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.phl.business.domain.client.dto.ClientRequestDto;
import com.phl.business.domain.store.model.Store;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ClientTbl")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String firstName;


    private String lastName;

    private String email;

    private String mobileNumber;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Store> stores;

    public Client updateFrom(ClientRequestDto clientRequestDto){
        this.firstName = clientRequestDto.getFirstName();
        this.lastName = clientRequestDto.getLastName();
        this.email = clientRequestDto.getEmail();
        this.mobileNumber = clientRequestDto.getMobileNumber();
        return this;
    }

    public void addStore(Store store){
        if(this.stores == null){
            this.stores = new ArrayList<>();
        }
        store.setClient(this);
        this.stores.add(store);
    }

}
