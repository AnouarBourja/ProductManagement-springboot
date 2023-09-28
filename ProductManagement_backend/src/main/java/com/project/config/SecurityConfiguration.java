package com.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                    .antMatchers("/showCreate","/saveProduct").hasAnyAuthority("ADMIN","AGENT")
                    .antMatchers("/ListProducts").hasAnyAuthority("ADMIN","AGENT","USER")
                    .antMatchers("/login","/webjars/**").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                .and()
                    .httpBasic()
                .and()
                    .exceptionHandling()
                    .accessDeniedPage("/accessDenied");
    }

    // In-memory authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder.encode("123"))
                .authorities("ADMIN")
                .and()
                .withUser("anouar")
                .password(passwordEncoder.encode("123"))
                .authorities("AGENT","USER")
                .and()
                .withUser("user1")
                .password(passwordEncoder.encode("123"))
                .authorities("USER");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

}
