package com.autosell.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Autowired
    CustomAuthenticationSuccessHandler successHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select user_name, password from user where user_name = ?")
                .authoritiesByUsernameQuery("select user_name, authority from authority where user_name = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/administration").hasRole("ADMIN")
                .antMatchers("/account").hasRole("SELLER")
                .antMatchers("/account").hasRole("BUYER")
                .antMatchers("/","/database/**").permitAll()
                .and().formLogin().loginPage("/signin")
                .successHandler(successHandler)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/signin");


        //Those two settings below is to enable access h2 database via browser
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
