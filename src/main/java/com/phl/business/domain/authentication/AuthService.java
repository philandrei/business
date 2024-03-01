package com.phl.business.domain.authentication;

import com.phl.business.domain.main.dto.RestResponse;
import com.phl.business.domain.token.TokenService;
import com.phl.business.domain.user.model.User;
import com.phl.business.domain.user.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.NoSuchElementException;

@Service
public class AuthService {

    @Autowired
    UserAuthenticationService userAuthenticationService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity<?> login(AuthRequest authRequest){

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getUsername(),
                            authRequest.getPassword()
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(401).body(RestResponse.builder().status(401).message(e.getMessage()).timestamp(new Date()).path(httpServletRequest.getRequestURI()).build());
        }
        User user = userRepository.findByUsername(authRequest.getUsername()).orElseThrow(() -> new NoSuchElementException());
        AuthUserDetails authUserDetails = new AuthUserDetails(user);
        String accessToken = userAuthenticationService.generateAccessToken(authUserDetails);
        String refreshToken = userAuthenticationService.generateRefreshToken(authUserDetails);
        tokenService.updateClientToken(user.getUuid(),accessToken,refreshToken);
        return ResponseEntity.ok(AuthResponse.builder()
                                         .accessToken(accessToken)
                                         .refreshToken(refreshToken)
                                         .build());
    }

}
