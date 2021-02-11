package ru.dezlo.room.security.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.dezlo.room.security.customDetail.CustomUserDetails;
import ru.dezlo.room.security.customDetail.CustomUserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;

import static org.springframework.util.StringUtils.hasText;

@Component
@Slf4j
public class JwtFilter extends GenericFilterBean {

    public static final String AUTHORIZATION = "authorization";

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        Enumeration<String> headerNames = httpRequest.getHeaderNames();

        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                log.debug("Header: " + httpRequest.getHeader(headerNames.nextElement()));
            }
        }

        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        log.debug("token: " + token);
        if (token != null && jwtProvider.validateToken(token)) {
            String userEmail = jwtProvider.getEmailFromToken(token);
            CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userEmail);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        String bearer = request.getHeader(AUTHORIZATION);
        log.debug("request.getHeader: " + bearer);
        if (hasText(bearer)) {
            log.debug("has text bearer: " + bearer);
            if (bearer.startsWith("Bearer ")) {
                log.debug("7: " + bearer.substring(7));
                return bearer.substring(7);
            }
        }
        return null;
    }
}