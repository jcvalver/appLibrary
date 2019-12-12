package com.teczuka.devp.appLibrary.configuration;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetails;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetails)
		 .passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		/**
		 * .antMatchers("/", "/home").permitAll()
		 * .antMatchers("/admin/**").access("hasRole('ADMIN')")
		 * .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
		 * .and().formLogin().loginPage("/login")
		 * .usernameParameter("ssoId").passwordParameter("password")
		 * .and().exceptionHandling().accessDeniedPage("/Access_Denied");
		 * 
		 * http.authorizeRequests() .anyRequest().authenticated()
		 * .and().formLogin().loginPage("/login") .permitAll();
		 * 
		 * http.logout().logoutUrl("/my/logout") .logoutSuccessUrl("/my/index")
		 * .logoutSuccessHandler(logoutSuccessHandler) .invalidateHttpSession(true)
		 * .addLogoutHandler(logoutHandler) .deleteCookies("JSESSIONID");
		 * 
		 */

		// authorize requests
		//http.authorizeRequests().antMatchers("/appLibrary/secure/**").access("hasRole('ROLE_ADMIN')");
		
		//si va
		//http.authorizeRequests().antMatchers("/appLibrary/**").access("hasRole('ROLE_ADMIN')");
		
		//http.authorizeRequests().anyRequest().hasAnyRole("USER","ADMIN");
		//http.authorizeRequests().anyRequest("/appLibrary/**").access("hasRole('ADMIN')");
		//http.authorizeRequests() .anyRequest().authenticated()
		// .and().formLogin().loginPage("/login") .permitAll();

		// login configuration
	    // si va
		//http.formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("username")//
		//		.passwordParameter("password").defaultSuccessUrl("/welcome").failureUrl("/login?error");

		// logout configuration
		// si va 
		//http.logout().logoutUrl("/login?logout");
	//	.permitAll()
	//	.and()
	//	.csrf().disable();
       /* .invalidateHttpSession(true)
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(new Http403ForbiddenEntryPoint())
        .and()
        .csrf()//Disabled CSRF protection
        .disable();*/
		
		/*
		 * logoutSuccessHandler(basicLogoutSuccessHandler)
				.invalidateHttpSession(true).deleteCookies("JSESSIONID");
		 */
		
		
		 http
         .authorizeRequests()
         .antMatchers("/login/**").permitAll()
         .antMatchers("/appLibrary/resources/**").permitAll()
         .antMatchers("/appLibrary/user/**").permitAll()
         .antMatchers("/appLibrary/**").authenticated()
         .and()
         .formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("username")//
         .passwordParameter("password").defaultSuccessUrl("/dashboard").permitAll()//;//.failureUrl("/login?error").permitAll();
		 .and().logout().logoutUrl("/logout") .logoutSuccessUrl("/login?logout")//;// .invalidateHttpSession(true).deleteCookies("JSESSIONID");		
		 .and()
         .csrf()//Disabled CSRF protection
         .disable();
	}

}
