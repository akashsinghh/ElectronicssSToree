package com.lcea.electronic.store.ElectronicssSTore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
//    @Autowired
//    private UserDetailsService userDetailsService;
    private final String[] PUBLIC_URLS={
            "/swaggers-ui/**",
            "/webjars/**",
            "/swaggers-resources/**",
        "/v3/api-docs"
};
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails normal=User.builder()
                .username("Akash")
                .password(passwordEncoder().encode("Akash@11"))
                .roles("NORMAL")
                .build();
        UserDetails admin= User.builder()
                .username("Shubh")
                .password(passwordEncoder().encode("Shub@11"))
                .roles("ADMIN")
                .build();
               return new InMemoryUserDetailsManager(normal,admin);
    }//form based authentication
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests().anyRequest().authenticated().and()
//                .formLogin()
//                .loginPage("login.html")
//                .loginProcessingUrl("/process-url")
//                .defaultSuccessUrl("/dashboard")
//                .failureUrl("error")
//                .and()
//                .logout()
//                .logoutUrl("/do-logout");
//        return http.build();
        http.csrf()
                .disable()
                .cors()
                .disable()
                .  authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();

    }

//    @Bean
//    public DaoAuthenticationProvider authenticationProvider(){
//    DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
//    daoAuthenticationProvider.setUserDetailsService(this.userDetailsService);
//    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//    return daoAuthenticationProvider;
//    }

  @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

