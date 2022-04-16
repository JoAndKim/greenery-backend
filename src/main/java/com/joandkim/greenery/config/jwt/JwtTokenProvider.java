package com.joandkim.greenery.config.jwt;


import com.joandkim.greenery.service.MemberService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    private String secretKey = "greenery2.0";

    private final long TOKEN_VALID_TIME = 30 * 60 * 1000L; // 30 min

    private final MemberService memberService;

    // init object encoding secretKey with Base64
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String userPk) {
        Claims claims = Jwts.claims().setSubject(userPk);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now) // token issue time
                .setExpiration(new Date(now.getTime() + TOKEN_VALID_TIME)) // set expiry time
                .signWith(SignatureAlgorithm.HS256, secretKey)  // algorithm for encrypting and secretKey for signature
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = memberService.loadUserByUsername(this.getMemberPk(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    // extract member identification value from JWT
    public String getMemberPk(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    // get token from http header
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }

    // validate expiry date from token
    public boolean validateToken(String jwtToken) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
