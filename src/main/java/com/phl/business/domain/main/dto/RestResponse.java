package com.phl.business.domain.main.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class RestResponse {
    private Date timestamp;
    private int status;
    private String message;
    private Object data;
}
