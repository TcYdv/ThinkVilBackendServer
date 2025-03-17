package com.Twitter.Jarvis.Config;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class AppConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests(Authorize -> Authorize.requestMatchers("/api/**").authenticated()
                        .requestMatchers("/error").permitAll()
                        .requestMatchers(HttpMethod.OPTIONS).permitAll()
                        .anyRequest().permitAll()
                )
                .addFilterBefore(new JwtTokenValidator(), BasicAuthenticationFilter.class)
                .csrf().disable()
                .cors().and()
                .httpBasic();

        return http.build();
    }

    private CorsConfigurationSource corsConfigurationSource(){

            return new CorsConfigurationSource(){
                @Override
                public CorsConfiguration getCorsConfiguration(HttpServletRequest request){
                    CorsConfiguration cfg = new CorsConfiguration();
                    cfg.setAllowedOrigins(Arrays.asList("http://localhost:3000", "https://v0-smart-agriculture-platform.vercel.app", "https://v0-smart-agricu-git-4cb88e-tarachandyadav018-gmailcoms-projects.vercel.app", "https://v0-smart-agriculture-platform-k0pojipi0.vercel.app", "https://v0-smart-agriculture-platf-tarachandyadav018-gmailcoms-projects.vercel.app", "https://v0-smart-agriculture-platform.vercel.app/jarvis-production-1e68.up.railway.app","https://v0-smart-agriculture-platform-fv24x0qzu.vercel.app/*"));
                    cfg.setAllowedMethods(Collections.singletonList("*"));
                    cfg.setAllowCredentials(true);
                    cfg.setAllowedHeaders(Collections.singletonList("*"));
                    cfg.setExposedHeaders(Arrays.asList("Authorization"));
                    cfg.setMaxAge(3600L);

                    return cfg;
                }
            };
        }

        @Bean
        public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }


}
