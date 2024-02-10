package com.phl.business.domain.main.helper;

import com.phl.business.domain.main.dto.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;

public class RestHelper {

    public ResponseEntity<RestResponse> buildSuccess(Object obj){
        return ResponseEntity.ok(RestResponse.builder()
                                         .timestamp(new Date())
                                         .status(200)
                                         .message("Success")
                                         .data(obj)
                                         .build());
    }
}
