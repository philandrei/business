package com.phl.business.domain.authentication;

import com.phl.business.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;

@Service
public class UserAuthenticationService {

    @Autowired
    private JWTUtil jwtUtil;

    @Value("${app.jwt.key}")
    private String defaultKey;



    public String generateAccessToken(AuthUserDetails userDetails) {
        Map<String, Object> claims = Map.of(
                "username", userDetails.getUsername()
        );
        return jwtUtil.generateMediumAccessToken(defaultKey, claims);
    }

    public String generateRefreshToken(AuthUserDetails userDetails) {
        Map<String, Object> claims = Map.of(
                "username", userDetails.getUsername()
        );
        return jwtUtil.generateLongAccessToken(defaultKey, claims);
    }

    public boolean isTokenValid(String token, AuthUserDetails userDetails){
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        return jwtUtil.extractTokenExpiration(defaultKey, token).before(new Date());
    }


    public String getUsernameFromToken(String token) {
        return jwtUtil.getKeyFromToken(defaultKey, token, "username");
    }

}
