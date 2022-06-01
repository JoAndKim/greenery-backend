package com.joandkim.greenery.config.jwt;

import com.joandkim.greenery.service.TokenService;
import com.joandkim.greenery.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;
    private final TokenService tokenService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // get JWT from header
        log.info("jwt authentication filter dofilter");
        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);
        // validate token
        boolean isValid = jwtTokenProvider.validateToken(token);
        if (token != null && isValid) {
            // get user info if token is valid
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            // SecurityContext 에 Authentication 객체를 저장합니다.
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        // 리프레쉬 토큰을 보낸 상태
        String refreshToken = jwtTokenProvider.resolveRefreshToken((HttpServletRequest) request);

        log.info("refreshToken: {}", refreshToken);

        // 리프레쉬 토큰이 null이 아니고 valid할떄 (유효기간 안지났ㅁ을떄)
        if (refreshToken != null && jwtTokenProvider.validateToken(refreshToken)) {
            String username = jwtTokenProvider.getMemberPk(refreshToken);

            log.info("refreshToken: {}", refreshToken);
            log.info("username: {}", username);

            // 디비와 비교
            boolean refreshTokenIsValid = tokenService.checkIfRefreshTokenIsValid(refreshToken, username);

            if (refreshTokenIsValid) {
                log.info("Refresh Token Is Valid");
                String newAccessToken = jwtTokenProvider.createToken(jwtTokenProvider.getMemberPk(refreshToken));
                ((HttpServletResponse) response).setHeader("Access-Token", newAccessToken);
                // get user info if token is valid
                Authentication authentication = jwtTokenProvider.getAuthentication(newAccessToken);
                // SecurityContext 에 Authentication 객체를 저장합니다.
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);
    }
}
