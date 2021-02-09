package ru.dezlo.room.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class JwtProvider {

    @Qualifier("customUserDetailsService")

    @Autowired
    UserDetailsService userDetailsService;

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateToken(String nickname, Integer id, String email) {

        Calendar calendar = Calendar.getInstance();
        log.debug(String.valueOf(calendar.getTime()));
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        log.debug(String.valueOf(calendar.getTime()));

        Map<String, Object> claims = new HashMap<>();
        claims.put("clientType", "user");
        claims.put("userID", id.toString());
        claims.put("nickname", nickname);
        claims.put("token_create_date", new Date().getTime());
        claims.put("token_expiration_date", calendar.getTime());
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setClaims(claims);
        return jwtBuilder
                .setSubject(email)
                .setHeaderParam("typ", "JWT")
                .setExpiration(calendar.getTime())
                .setId(id.toString())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, jwtSecret.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecret.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token).getBody();
            return true;
        } catch (Exception e) {
            log.debug("invalid token");
        }
        return false;
    }

    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(jwtSecret.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token).getBody();
        return claims.getId();
    }
}