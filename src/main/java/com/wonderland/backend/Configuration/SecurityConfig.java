package com.wonderland.backend.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {


    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilterRegistration() {
        FilterRegistrationBean<JwtFilter> registration = new FilterRegistrationBean<>();
        
        // 👇 USAMOS LA INSTANCIA, NO LA CLASE
        registration.setFilter(jwtFilter);

        registration.addUrlPatterns("/api/*"); // protege solo /api
        // este initParameter no lo usas realmente, lo puedes quitar si quieres
        // registration.addInitParameter("exclude", "/api/user/login,/api/user/register");

        return registration;
    }
}
