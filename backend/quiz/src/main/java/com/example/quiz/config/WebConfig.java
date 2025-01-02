package com.example.quiz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow CORS on all endpoints
                .allowedOrigins("http://localhost:3000")  // Replace with the frontend URL (React default port)
                .allowedMethods("GET", "POST", "PUT", "DELETE")  // Specify allowed methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(true);  // Allow credentials if needed (like cookies, authorization headers)
    }
}
