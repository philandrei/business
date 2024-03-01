package com.phl.business.domain.user.model;

import com.phl.business.base.AbstractEntity;
import com.phl.business.domain.authentication.AuthUserDetails;
import com.phl.business.domain.client.model.Client;
import com.phl.business.domain.store.model.Store;
import com.phl.business.domain.user.dto.UserRequestDto;
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
public class User extends AbstractEntity<User> {

    private String username;

    private String password;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Client client;

    public User updateFrom(UserRequestDto userRequestDto){
        this.username = userRequestDto.getUsername();
        return this;
    }

    public AuthUserDetails toAuthUserDetails(){
        return new AuthUserDetails(this);
    }

}
