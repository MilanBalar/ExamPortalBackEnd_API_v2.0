package com.boot.server.exam.springsecurityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.boot.server.exam.service.impl.UserDetailsSeviceImplSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // use for identify the role. which user have which API access.
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailsSeviceImplSecurity userDetailsSeviceImplSecurity;

	@Autowired
	private JwtAuthenticationEntryPoint unAuthorizeHandler;

	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

   @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailsSeviceImplSecurity).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		     .csrf()
		     .disable()
		     .cors()
		     .disable()
		     .authorizeRequests()
		     .antMatchers("/generateToken","/user/").permitAll()
		     .antMatchers(HttpMethod.OPTIONS).permitAll()
		     .anyRequest().authenticated()
		     .and()
		     .exceptionHandling().authenticationEntryPoint(unAuthorizeHandler)
		     .and()
		     .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);


	}



}
