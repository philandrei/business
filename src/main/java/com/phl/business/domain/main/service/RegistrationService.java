package com.phl.business.domain.main.service;

import com.phl.business.domain.main.dto.RegistrationRequest;
import com.phl.business.domain.main.dto.RestResponse;
import org.springframework.http.ResponseEntity;

public interface RegistrationService {

    ResponseEntity<RestResponse> registration(RegistrationRequest registrationRequest);

}
