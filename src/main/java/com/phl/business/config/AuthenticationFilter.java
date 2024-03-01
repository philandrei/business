package com.phl.business.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phl.business.domain.authentication.AuthUserDetails;
import com.phl.business.domain.authentication.AuthUserDetailsService;
import com.phl.business.domain.authentication.UserAuthenticationService;
import com.phl.business.domain.main.dto.RestResponse;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserAuthenticationService authenticationService;
    @Autowired
    private AuthUserDetailsService authUserDetailsService;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, MalformedJwtException {
        if (request.getRequestURI().contains("/auth") || request.getRequestURI().contains("/nosession") || request.getRequestURI().contains("/registrations")) {
            filterChain.doFilter(request, response);
            return;
        }

        final String authHeader = request.getHeader("Authorization");
        final String jwt;
        final String username;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            errorResponse(request, response, "Invalid access token", 400);
            return;
        }

        try {
            jwt = authHeader.substring(7);
            username = authenticationService.getUsernameFromToken(jwt);
        } catch (Exception e) {
            errorResponse(request, response, "Invalid access token", 400);
            return;
        }


        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            AuthUserDetails userDetails = this.authUserDetailsService.loadUserByUsername(username);

            if (authenticationService.isTokenValid(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);

    }

    private void errorResponse(HttpServletRequest request, HttpServletResponse response, String message, int status) throws IOException {
        RestResponse restResponse = RestResponse.builder()
                                            .path(request.getRequestURI())
                                            .status(400)
                                            .timestamp(new Date())
                                            .message(message)
                                            .build();
        String objStr = new ObjectMapper().writeValueAsString(restResponse);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.setStatus(status);
        response.getWriter().write(objStr);
        response.getWriter().flush();
    }
}