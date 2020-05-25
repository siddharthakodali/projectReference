package com.projectreference.reference;

import com.projectreference.reference.Utils.JwtRequestFIlter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    JwtRequestFIlter jwtRequestFIlter;

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
     *
     * @param auth
     * @throws Exception
     */
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("Select * from user"
                        + " where username = ?")
                .authoritiesByUsernameQuery(" select username, authority"
                        + "from authorities where username = ?");
    }*/

    /**
     * authorization connecting to database
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    /**
     * role based authorization
     *
     * @return
     */
    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("admin")
                .antMatchers("/user").hasAnyRole("user", "admin")
                .antMatchers("/").permitAll()
                .and().formLogin();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().antMatchers("/authenticate")
                .permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFIlter, UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * LDAP authentication
     * @param
     * @throws Exception
     */
    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
                .userDnPatterns("uid={0},ou=people")
                .groupSearchBase("ou=group")
                .contextSource()
                .url("ldap://localhost:8389/dc=springframework,dc=org")
                .and()
                .passwordCompare()
                .passwordEncoder(new LdapShaPasswordEncoder())
                .passwordAttribute("userPassword");
    }*/


   /* @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().fullyAuthenticated()
                .and()
                .formLogin();

    }*/



    @Bean
    public PasswordEncoder getpasswordencoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
