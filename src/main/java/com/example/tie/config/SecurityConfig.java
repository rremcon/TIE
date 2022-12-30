//package com.example.tie.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    //WEL GEBRUIKEN!
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    //Dit gaan we NIET gebruiken
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        InMemoryUserDetailsManager man = new InMemoryUserDetailsManager();
//
//        UserDetails u1 = User
//                .withUsername("user")
//                .password( encoder.encode("user"))
//                .roles("USER")
//                .build();
//        man.createUser(u1);
//
//
//        UserDetails u2 = User
//                .withUsername("admin")
//                .password( encoder.encode("admin"))
//                .roles("ADMIN")
//                .build();
//        man.createUser(u2);
//
//        return man;
//
//    }
//
//
//    //Authorisation (WEL gebruiken)
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .httpBasic()
////                .and().csrf().disable()
//                .and()
//                .authorizeHttpRequests()
////                .anyRequest()
////                .authenticated();
////                .requestMatchers("/televisions").permitAll()
//                .requestMatchers("/televisions/**").hasAnyRole("USER", "ADMIN")
//                .requestMatchers(HttpMethod.GET, "/televisions/{id}").hasAnyRole("USER", "ADMIN")
//                .requestMatchers(HttpMethod.GET, "/televisions").hasAnyRole("USER", "ADMIN")
//                .requestMatchers(HttpMethod.POST, "/televisions").hasRole("ADMIN")
//                .requestMatchers("/**").hasRole("ADMIN")
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        return http.build();
//    }
//
//}
//
