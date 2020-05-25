package com.projectreference.reference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    /**
     * In memory authentication
     * @param
     * @throws Exception
     */
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("hello")
                .password("hello")
                .roles("users")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("admin");
    }*/

    /**
     * Database authentication with default schema
     *
     * @param
     * @throws Exception
     */
/*    @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.jdbcAuthentication()
               .dataSource(dataSource)
               .withDefaultSchema()
               .withUser(
                       User.withUsername("user")
                       .password("user")
                       .roles("USER")
               )
               .withUser(
                       User.withUsername("admin")
                       .password("admin")
                       .roles("ADMIN")
               );
   }*/

    /**
     * Database by using query authentication
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("Select * from user"
                        + " where username = ?")
                .authoritiesByUsernameQuery(" select username, authority"
                        + "from authorities where username = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("admin")
                .antMatchers("/user").hasAnyRole("user", "admin")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder getpasswordencoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
