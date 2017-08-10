package com.rkovtiuk.blog_ms.auth.domain.handlers;

import com.google.common.io.BaseEncoding;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Component
public class TokenHandler {

    private final SecretKey secretKey;

    public TokenHandler(){
        String jwtKey = "jwtkey1234567890";
        byte[] decodedKey = BaseEncoding.base64().decode(jwtKey);
        secretKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
    }

    public Optional<Integer> extractUserId(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            Claims body = claimsJws.getBody();
            return Optional
                    .ofNullable(body.getId())
                    .map(Integer::new);
        } catch (RuntimeException e){
            return Optional.empty();
        }
    }

    public String generateAccessToken(Integer id, LocalDateTime expires){
        return Jwts.builder()
                .setId(id.toString())
                .setExpiration(Date.from(expires.atZone(ZoneId.systemDefault()).toInstant()))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }



}
