package com.phl.business.domain.main.rest;

import com.phl.business.domain.main.dto.RegistrationRequest;
import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.main.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrations")
public class RegistrationRestController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/client")
    public ResponseEntity<RestResponse> register(@RequestBody RegistrationRequest registrationRequest) {
        return registrationService.registration(registrationRequest);
    }
}
