package com.phl.business.config;

import com.phl.business.domain.main.dto.RestResponse;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    private final HttpServletRequest servletRequest;


    @ExceptionHandler(value
                              = {BadCredentialsException.class})
    protected ResponseEntity<RestResponse> badCredentialException(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return responseOf(HttpStatus.UNAUTHORIZED, bodyOfResponse);
    }

    @ExceptionHandler(value
                              = {AccessDeniedException.class})
    protected ResponseEntity<RestResponse> accessDeniedException(
            RuntimeException ex, WebRequest request) {
        System.out.println(request);
        String bodyOfResponse = ex.getMessage();
        return responseOf(HttpStatus.FORBIDDEN, bodyOfResponse);
    }

    @ExceptionHandler(MalformedJwtException.class)
    protected ResponseEntity<RestResponse> invalidJWTException(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return responseOf(HttpStatus.BAD_REQUEST, bodyOfResponse);
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    protected ResponseEntity<RestResponse> internalServerError(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return responseOf(HttpStatus.INTERNAL_SERVER_ERROR, bodyOfResponse);
    }

    private ResponseEntity<RestResponse> responseOf(HttpStatus status, String message) {
        return ResponseEntity.status(status.value()).body(buildResponseBody(status, message));
    }


    private RestResponse buildResponseBody(HttpStatus status, String message) {
        return RestResponse.builder()
                       .path(servletRequest.getRequestURI())
                       .timestamp(new Date())
                       .status(status.value())
                       .message(message)
                       .build();
    }
}