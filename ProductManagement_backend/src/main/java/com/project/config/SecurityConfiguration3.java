package com.project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration3
{

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests((requests)->requests
                        //.requestMatchers("/showCreate","/saveProduct").hasAnyAuthority("ADMIN","AGENT")
                        //.requestMatchers("/ListeProducts").hasAnyAuthority("ADMIN","AGENT","USER")
                        //.requestMatchers("/login","/webjars/**").permitAll()
                        .anyRequest().authenticated())

                .formLogin((formLogin) ->   formLogin
                        .loginPage("/login")
                        .defaultSuccessUrl("/") )

                .httpBasic(Customizer.withDefaults())
                .exceptionHandling((exception)-> exception.accessDeniedPage("/accessDenied"));
        return http.build();
    }



	   /* @Bean
	    public InMemoryUserDetailsManager userDetailsService()
	    {
	      PasswordEncoder passwordEncoder = passwordEncoder ();
	      System.out.println("Password Encoded BCRYPT :******************** ");
	  	  System.out.println(passwordEncoder.encode("123"));


	    	UserDetails admin = User
	    			.withUsername("admin")
	                .password(passwordEncoder.encode("123"))
	                .authorities("ADMIN")
	                .build();
	        UserDetails userAnouar = User
	                .withUsername("anouar")
	                .password(passwordEncoder.encode("123"))
	                .authorities("AGENT","USER")
	                .build();
	        UserDetails user1 = User
	                .withUsername("user1")
	                .password(passwordEncoder.encode("123"))
	                .authorities("USER")
	                .build();

	        return new InMemoryUserDetailsManager(admin, userAnouar,user1);
	    }
	    */

	  /*  @Bean
	    public UserDetailsService userDetailsService(DataSource dataSource)
	    {
	    	JdbcUserDetailsManager jdbcUserDetailsManager =new JdbcUserDetailsManager(dataSource);

	    	jdbcUserDetailsManager.setUsersByUsernameQuery("select username , password , enabled from user where username =?");
	    	jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("SELECT u.username, r.role as authority   " +
	    			"FROM user_role ur, user u , role r " +
	    	        "WHERE u.user_id = ur.user_id AND ur.role_id = r.role_id AND u.username = ?");

	    	return jdbcUserDetailsManager;
	    }
	    */

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


}