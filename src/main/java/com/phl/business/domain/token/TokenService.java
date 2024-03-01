package com.phl.business.domain.token;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class TokenService {

    @Autowired
    TokenRepository tokenRepository;
    private void save(Token token){
        tokenRepository.save(token);
    }

    boolean isRefreshTokenValid(String userId, String refreshToken){
        Token token = getTokenByUserId(userId);
        if(token.getRefresh_token().equals(refreshToken)){
            return true;
        }
        return false;
    }

    public void updateClientToken(String userId, String accessToken, String refreshToken){
        Token token = getTokenByUserId(userId);
        updateToken(token,accessToken,refreshToken);
    }

    private void updateToken(Token token, String accessToken,String refreshToken){
        token.setAccess_token(accessToken);
        token.setRefresh_token(refreshToken);
        save(token);
    }

    private Token getTokenByUserId(String userId){
        return tokenRepository.findByUserId(userId).orElseThrow(() -> new NoSuchElementException("Invalid user Id"));
    }

    public void createInitialTokenForClient(String userId){
        tokenRepository.save(Token.builder()
                                     .userId(userId)
                                     .build());
    }
}
