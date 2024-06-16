package com.meta.server.auth;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yuvraj Singh
 */
@Configuration
public class ApplicationConfig {
    private final JWTService jwtService;

    public ApplicationConfig(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @Bean
    public FilterRegistrationBean<AuthenticationFilter> authenticationFilter() {
        FilterRegistrationBean<AuthenticationFilter> registration = new FilterRegistrationBean<AuthenticationFilter>();
        registration.setFilter(new AuthenticationFilter(jwtService));
        registration.addUrlPatterns("/api/v1/*");
        return registration;
    }
}
