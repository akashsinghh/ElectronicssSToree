//package com.lcea.electronic.store.ElectronicssSTore.security;
//
//import io.jsonwebtoken.Claims;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class Jwthelper {
//    //requirement
//    public static final  long JWT_TOKEN_VALIDITY=5*60*60;
//
//    @Value("${jwt.secret}")
//    private String secret;
//    //retrive username from jwt token
//    public String getUsernameFromToken(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//
//    }
//    //retrive expiration date   from jwt token
//    public Date getExpirationDateFromToken(String token){
////        return getClaimFromToken(token,Claims::getExpiration);
//
//
//    }
//
//    public Boolean validateToken(String token, UserDetails userDetails) {
//    }
//}
