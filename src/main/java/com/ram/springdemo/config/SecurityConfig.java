package com.ram.springdemo.config;


import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ram.springdemo.security.CustomUserDetailsService;
import com.ram.springdemo.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		  System.out.println("SecurityFilterChain Loaded");
		
		http
			
			.csrf(csrf->csrf.disable())
			.authorizeHttpRequests(auth-> auth
					.requestMatchers("/auth/**").permitAll()
					
					.requestMatchers(
							"/v3/api-docs/**",
							"/swagger-ui/**",
							"/swagger-ui.html"
							).permitAll()
					
					
					.requestMatchers("/save")
					.hasRole("ADMIN")
					
					.requestMatchers("/students","/students/**")
				
					.hasAnyRole("ADMIN","USER")
					.anyRequest().authenticated()
					
			)	
			.addFilterBefore(jwtAuthenticationFilter,
					UsernamePasswordAuthenticationFilter.class);
		//	.httpBasic(Customizer.withDefaults());
		
		return http.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		
		return config.getAuthenticationManager();
	}
	
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
		
	//	provider.setUserDetailsService(userDetailsService);
		
		provider.setPasswordEncoder(passwordEncoder);
		
		return provider;
	}
	

	
//	@Autowired
//	private CustomUserDetailsService userDetailsService;
//	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	@Autowired
//	private JwtAuthenticationFilter jwtAuthenticationFilter;
//	
	
	
	

}
