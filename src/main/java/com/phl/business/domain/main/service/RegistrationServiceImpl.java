package com.phl.business.domain.main.service;

import com.phl.business.domain.client.model.Client;
import com.phl.business.domain.client.repository.ClientRepository;
import com.phl.business.domain.main.dto.RegistrationRequest;
import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.main.helper.RestHelper;
import com.phl.business.domain.user.model.User;
import com.phl.business.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl extends RestHelper implements RegistrationService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;
    @Override
    public ResponseEntity<RestResponse> registration(RegistrationRequest registrationRequest) {
        Client client = Client.builder()
                                    .firstName(registrationRequest.getFirstName())
                                    .lastName(registrationRequest.getLastName())
                                    .mobileNumber(registrationRequest.getMobileNumber())
                                    .email(registrationRequest.getEmail())
                                    .build();
        User user = User.builder()
                            .username(registrationRequest.getUsername())
                            .password(passwordEncoder.encode(registrationRequest.getPassword()))
                            .client(client)
                            .build();

        userRepository.save(user);
        return buildSuccess(user);
    }

}
