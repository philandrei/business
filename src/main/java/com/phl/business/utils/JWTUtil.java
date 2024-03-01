package com.phl.business.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class JWTUtil {

    @Value("${app.jwt.key}")
    private String defaultKey;

    @Value("${app.jwt.type}")
    private String type;
    @Value("${app.jwt.issuer}")
    private String issuer;
    @Value("${app.jwt.subject}")
    private String subject;
    @Value("${app.jwt.audience}")
    private String audience;

    @Value("${app.jwt.expiry.min}")
    private Long shortExpiration;
    @Value("${app.jwt.expiry.mid}")
    private Long mediumExpiration;
    @Value("${app.jwt.expiry.max}")
    private Long longExpiration;

    public String generateShortAccessToken(String signingKey, Map<String, Object> claims) {
        return generateJWT(issuer, subject, audience,
                new Date(System.currentTimeMillis() + shortExpiration), new Date(), signingKey, claims);
    }


    public String generateMediumAccessToken(String signingKey, Map<String, Object> claims) {
        return generateJWT(issuer, subject, audience,
                new Date(System.currentTimeMillis() + mediumExpiration), new Date(), signingKey, claims);
    }


    public String generateLongAccessToken(String signingKey, Map<String, Object> claims) {
        return generateJWT(issuer, subject, audience,
                new Date(System.currentTimeMillis() + longExpiration), new Date(), signingKey, claims);
    }


    public String generateJWT(String signingKey, Date expiration, Map<String, Object> claims) {
        return generateJWT(issuer, subject, audience, expiration, new Date(), signingKey, claims);
    }


    public String generateJWT(String signingKey, long expiration, Map<String, Object> claims) {
        return generateJWT(issuer, subject, audience, expiration > 0 ? new Date(System.currentTimeMillis() + expiration) : null, new Date(), signingKey, claims);
    }


    public String generateJWT(String signingKey, String issuer, String subject, String audience,
                              Date expiration, Map<String, Object> claims) {
        return generateJWT(issuer, subject, audience, expiration, new Date(), signingKey, claims);
    }

    public String generateJWT(String signingKey, Date expiration, Date issuedDate, Map<String, Object> claims) {
        return generateJWT(issuer, subject, audience, expiration, issuedDate, signingKey, claims);
    }


    public String generateJWT(String issuer, String subject, String audience,
                              Date expiration, Date issuedDate, String signingKey, Map<String, Object> claims) {
        JwtBuilder builder = Jwts.builder()
                                     .signWith(SignatureAlgorithm.HS256, signingKey.getBytes())
                                     .setHeaderParam("typ", type)
                                     .setIssuer(issuer)
                                     .setSubject(subject)
                                     .setAudience(audience)
                                     .setExpiration(expiration)
                                     .setIssuedAt(issuedDate)
                                     .setId(UUID.randomUUID().toString());
        for (Map.Entry<String, Object> entry : claims.entrySet()) {
            builder = builder.claim(entry.getKey(), entry.getValue());
        }
        String token = builder.compact();
        log.debug("Generate access token : {}", token);
        return token;
    }


    public String getKeyFromToken(String signingKey, String token, String key) {
        Claims claims = getClaims(signingKey, token);
        return claims.get(key).toString();
    }

    public boolean isTokenExpired(String token, String signingKey) {
        return extractTokenExpiration(signingKey, token).before(new Date());
    }

    public Date extractTokenExpiration(String signingKey, String token) {
        return getClaims(signingKey, token).getExpiration();
    }

    public Claims getClaims(String signingKey, String token) {
        return Jwts.parser()
                       .setSigningKey(signingKey.getBytes())
                       .parseClaimsJws(token)
                       .getBody();
    }


}