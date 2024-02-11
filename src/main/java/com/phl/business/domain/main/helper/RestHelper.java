package com.phl.business.domain.main.helper;

import com.phl.business.domain.authentication.AuthUserDetails;
import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.user.model.User;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Slf4j
public class RestHelper {
    @Autowired
    HttpServletRequest httpServletRequest;

    protected User getUser() {
        AuthUserDetails authUserDetails = (AuthUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return authUserDetails.getUser();

    }

    protected String getClientId() {
        User user = getUser();
        return user.getClient().getUuid();
    }

    public ResponseEntity<RestResponse> buildSuccess(Object obj){
        log.info("[buildSuccess] Building success response");
        return ResponseEntity.ok(RestResponse.builder()
                                         .path(httpServletRequest.getRequestURI())
                                         .timestamp(new Date())
                                         .status(200)
                                         .message("Success")
                                         .data(obj)
                                         .build());
    }
}
