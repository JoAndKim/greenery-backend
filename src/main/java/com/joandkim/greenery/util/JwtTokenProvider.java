package com.joandkim.greenery.util;


import com.joandkim.greenery.service.member.MemberService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${jwt.secretKey}")
    private String secretKey;

    private final long TOKEN_VALID_TIME = 30 * 60 * 1000L; // 30 min
//    private final long TOKEN_VALID_TIME = 5L; // 30 min
    private final long REFRESH_TOKEN_VALID_TIME = 30 * 48 * 30 * 60 * 1000L; // 30 days

    private final MemberService memberService;

    // init object encoding secretKey with Base64
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String memberPk) {
        Claims claims = Jwts.claims().setSubject(memberPk);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now) // token issue time
                .setExpiration(new Date(now.getTime() + TOKEN_VALID_TIME)) // set expiry time
                .signWith(SignatureAlgorithm.HS256, secretKey)  // algorithm for encrypting and secretKey for signature
                .compact();
    }

    public String createRefreshToken(String memberPk) {
        Claims claims = Jwts.claims().setSubject(memberPk);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now) // token issue time
                .setExpiration(new Date(now.getTime() + REFRESH_TOKEN_VALID_TIME)) // set expiry time
                .signWith(SignatureAlgorithm.HS256, secretKey)  // algorithm for encrypting and secretKey for signature
                .compact();
    }

    public String getRefreshTokenExpiryTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return simpleDateFormat.format(new Date(new Date().getTime() + REFRESH_TOKEN_VALID_TIME));
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
        return request.getHeader("Authorization");
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

    public String resolveRefreshToken(HttpServletRequest request) {
        return request.getHeader("Authorization-Refresh");
    }
}
