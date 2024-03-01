package com.phl.business.domain.token;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    @Lob
    private String access_token;

    @Lob
    private String refresh_token;

    private String userId;
}
