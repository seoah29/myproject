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

import com.my.project.service.CustomUserDetailsService;

import jakarta.servlet.http.HttpSession;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	private final PasswordEncoder passwordEncoder;

	public SecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.csrf().disable() // csrf 토큰 사용 X
				.cors().disable() // cors 방지
				.headers().frameOptions().disable();

		http.formLogin(login -> login.loginPage("/member/login").loginProcessingUrl("/member/login")
				.usernameParameter("memberId").passwordParameter("memberPasswd").defaultSuccessUrl("/", true)
				.successHandler((request, response, authentication) -> {
	                // 로그인 성공 후 처리할 로직
	                // 예: 성공 로그를 남기거나, 세션에 정보를 추가
	                response.sendRedirect("/main");
				}))
				// 로그아웃 설정
				.logout(logout -> logout
						// 로그아웃 요청을 처리할 URL 설정
						.logoutUrl("/logout")
						// 로그아웃 성공 시 리다이렉트할 URL 설정
						.logoutSuccessUrl("/main")
						// 로그아웃 핸들러 추가 (세션 무효화 처리)
						.addLogoutHandler((request, response, authentication) -> {
							HttpSession session = request.getSession();
							session.invalidate();
						})
						// 로그아웃 성공 핸들러 추가 (리다이렉션 처리)
						.logoutSuccessHandler((request, response, authentication) -> response.sendRedirect("/main"))
						// 로그아웃 시 쿠키 삭제 설정 
						.deleteCookies("remember-me"));
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurity() {

		// 정적 리소스 (css) 등 로그인 권한 필요 X
		return (web) -> web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
	}
}
