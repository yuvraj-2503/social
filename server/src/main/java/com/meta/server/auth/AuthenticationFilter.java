package com.meta.server.auth;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * @author Yuvraj Singh
 */
@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    private JWTService jwtService;

    public AuthenticationFilter(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            final String jwt = authHeader.substring(7);
            String userId = null;
            try {
                userId = jwtService.extractUsername(jwt);
            } catch (Exception e) {
                throw new ServletException("Invalid token");
            }

            if (userId != null && !jwtService.isTokenExpired(jwt)) {
                request.setAttribute("userId", userId);
            }else{
                throw new ServletException("Invalid token");
            }

            filterChain.doFilter(request, response);
        } catch (Exception exception) {
            throw new ServletException(exception);
        }
    }
}
