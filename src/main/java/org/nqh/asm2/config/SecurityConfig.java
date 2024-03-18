package org.nqh.asm2.config;

import org.nqh.asm2.config.handler.CustomAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private CustomAuthenticationSuccessHandler authenticationSuccessHandler;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Tắt CSRF để form có thể submit được (mặc định là bật)
                .csrf(csrf -> csrf.disable())
                // Cấu hình cho phép truy cập vào các đường dẫn tĩnh mà không cần đăng nhập 
                .authorizeHttpRequests((authorize) -> authorize
                            .requestMatchers("/", "/home", "/auth/login", "/auth/register", "/assets/**")
                            .permitAll()
                        .anyRequest().authenticated())
                // Cấu hình form đăng nhập
                .formLogin((formLogin) -> formLogin
                        .loginPage("/auth/login")
                        .successHandler(authenticationSuccessHandler)
                        .failureUrl("/auth/login?error")
                        .permitAll())
                // Cấu hình cho phép logout
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout", "GET"))
                        .logoutSuccessUrl("/auth/login")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID"));
        return http.build();
    }

    

    // Cấu hình xác thực dựa trên UserDetailsService và mã hóa mật khẩu bằng BCryptPasswordEncoder
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Cấu hình xác thực dựa trên UserDetailsService
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

}
