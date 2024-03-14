package com.my.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	private final PasswordEncoder passwordEncoder;

    public SecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        String password = this.passwordEncoder.encode("1111");
        auth.inMemoryAuthentication()
            .withUser("user").password(password).roles("USER");
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
        http
	        .csrf().disable() // csrf 토큰 사용 X
	        .cors().disable() // cors 방지
	        .headers().frameOptions().disable();
        
        http
        	.formLogin(login -> login
        	    .loginPage("/member/login")
        	    .loginProcessingUrl("/member/login")
        	    .usernameParameter("memberId")
        	    .passwordParameter("memberPasswd")
        	    .defaultSuccessUrl("/", true)
        	)
	        .logout()
	        .logoutSuccessUrl("/main"); // 로그아웃 성공 시 '/'로 리디렉션 변경

        return http.build();
    }
    
    @Bean
    public WebSecurityCustomizer webSecurity() {
    	
    	// 정적 리소스 (css) 등 로그인 권한 필요 X
    	return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }
}
