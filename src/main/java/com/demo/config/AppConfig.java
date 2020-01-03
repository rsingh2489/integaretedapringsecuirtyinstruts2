package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@ComponentScan("com.demo")
@EnableTransactionManagement
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		//httpSecurity.cors().and().csrf().disable();
		httpSecurity.csrf().disable();

		httpSecurity.authorizeRequests()
					.antMatchers("/welcome").access("hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_SUPER_ADMIN')")
					//.antMatchers("/menu1").access("hasRole('ROLE_ADMIN')")
					//.antMatchers("/menu2").access("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
					//.antMatchers("/menu3").access("hasRole('ROLE_USER')")
					.antMatchers("/user/**").access("hasAnyRole('ROLE_USER','ROLE_SUPER_ADMIN','ROLE_ADMIN')")
					.antMatchers("/admin/**").access("hasAnyRole('ROLE_ADMIN','ROLE_SUPER_ADMIN')")
					.antMatchers("/superadmin/**").access("hasRole('ROLE_SUPER_ADMIN')")
					.and()
					.formLogin()
					.loginPage("/login")
					.defaultSuccessUrl("/welcome")
					.failureUrl("/login?error")
					.usernameParameter("username").passwordParameter("password")
					.and()
					.logout()
					.logoutUrl("/j_spring_security_logout")
					.logoutSuccessUrl("/login?logout").and()
					//.exceptionHandling()
					//.accessDeniedPage("/dashboard/accessDenied.html")
					;
	}

/*	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}*/

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password(passwordEncoder().encode("admin")).authorities("ROLE_ADMIN")
			.and()
			.withUser("user").password(passwordEncoder().encode("user")).authorities("ROLE_USER")
			.and()
			.withUser("superadmin").password(passwordEncoder().encode("superadmin")).authorities("ROLE_SUPER_ADMIN");
	}

	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}