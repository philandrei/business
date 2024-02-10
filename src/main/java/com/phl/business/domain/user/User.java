package com.phl.business.domain.user;

import com.phl.business.domain.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "UserTbl")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    private String username;

    private String password;

    @OneToOne(fetch = FetchType.LAZY)
    private Customer customer;

    public User updateFrom(UserRequestDto userRequestDto){
        this.username = userRequestDto.getUsername();
        return this;
    }

}
