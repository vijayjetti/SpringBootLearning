package com.vijay.springbootlearning.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Below method was overridden for Authentication
     **/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("jetti").password("password").roles("user")
                // By using and we can add multiple users with required roles
                .and()
                .withUser("vijay").password("password").roles("admin");
        //auth.jdbcAuthentication().getUserDetailsService();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * Below method was overridden for Authorization
     **/
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                // Have to give access from most restricted to most used roles
                .antMatchers("/admin").hasAnyRole("admin")
                .antMatchers("/user").hasAnyRole("/user", "/admin")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }
}
