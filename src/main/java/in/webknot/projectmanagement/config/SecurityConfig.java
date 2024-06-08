package in.webknot.projectmanagement.config;

import  in.webknot.projectmanagement.security.JwtAuthenticationEntryPoint;
import  in.webknot.projectmanagement.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {


    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    public PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf-> csrf.disable())
                .cors(cors-> cors.disable())
                .authorizeHttpRequests(
                        auth->auth.requestMatchers("home/admin/**").hasRole("ADMIN")
                                .requestMatchers("home/**").authenticated()
                                .requestMatchers("/auth/login").permitAll()
                                .requestMatchers("api/employees/add").authenticated()
                                .requestMatchers("/api/allocations").authenticated()
                                .requestMatchers("/api/leaves").authenticated()
                                .requestMatchers("/auth/create-user").permitAll()
                                .requestMatchers("/admin/create-project").hasRole("ADMIN")
                                .requestMatchers("/admin/delete-project/{id}").hasRole("ADMIN")
                                .anyRequest().authenticated())
                 .exceptionHandling(ex->ex.authenticationEntryPoint(point))
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);

        return http.build();

    }
    @Bean
    public DaoAuthenticationProvider dodaoAuthenticationProvider(){

        DaoAuthenticationProvider Provider = new DaoAuthenticationProvider();
        Provider.setUserDetailsService(userDetailsService);
        Provider.setPasswordEncoder(passwordEncoder);
        return Provider;

    }
    }
