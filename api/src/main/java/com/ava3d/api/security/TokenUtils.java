package com.ava3d.api.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET_="Vgy`hxHt_FHjQ4'>3PTX,P|8$unqWa'ImC_sXc&8/|Oj4k)h?:.@f|4qVxCv?c{";
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS_=86400L;

    public static String createToken(String nombre,String email){

        Long expirationTime= ACCESS_TOKEN_VALIDITY_SECONDS_*1000;//se convierte a milisegundos
        Date expirationDate= new Date(System.currentTimeMillis()+expirationTime);

        Map<String,Object> extra= new HashMap<>();
        extra.put("nombre",nombre);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET_.getBytes()))
                .compact();
    }
    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET_.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email= claims.getSubject();
            return new UsernamePasswordAuthenticationToken(email,null, Collections.emptyList());

        }catch (JwtException e){
            return null;
        }
    }

    public static String getUserEmail(String token){
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET_.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email= claims.getSubject();
            return email;

        }catch (JwtException e){
            return null;
        }
    }


}
