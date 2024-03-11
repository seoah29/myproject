package com.my.project.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

    // 비밀번호 암호화
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	
        http
	        .csrf().disable() // csrf 토큰 사용 X
	        .cors().disable() // cors 방지
	        .headers().frameOptions().disable();
        
        http
	        .formLogin(login -> login	// form 방식 로그인 사용
	        		.loginPage("/member/login")
    				.loginProcessingUrl("/member/login")
			        .usernameParameter("memberId")	
			        .passwordParameter("memberPasswd")
    				.defaultSuccessUrl("/main", true)
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
    
    
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http
//                .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
//                        .requestMatchers(new AntPathRequestMatcher("/**")).permitAll()) 
//                .formLogin((formLogin)-> formLogin //formLogin 은 스프링 시큐리티의 로그인 설정을 담당하는 부분
//                        .loginPage("/member/login") //로그인 페이지 URL 지정
//                        .defaultSuccessUrl("/"))
//                .logout((logout) -> logout
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                        .logoutSuccessUrl("/")
//                        .invalidateHttpSession(true)) 
//        ;
//        return http.build();
//    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//            .authorizeRequests()
//                // '/' 경로 및 다른 공개 경로 설정
//                .requestMatchers("/", "/login", "/signup", "/main").permitAll() // 인증되지 않은 사용자도 접근 가능
//                .requestMatchers("/myblog").authenticated() // "/myblog"는 인증된 사용자만 접근 가능
//                .anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
//            .and()
//                .formLogin()
//                    .loginPage("/login") // 로그인 페이지 경로 설정
//                    .loginProcessingUrl("/login") // 로그인 처리 경로 설정
//                    .usernameParameter("memberId") // 사용자 id 파라미터 이름
//                    .passwordParameter("memberPasswd") // 사용자 password 파라미터 이름
//                    .defaultSuccessUrl("/main", true) // 로그인 성공 시 이동할 기본 경로를 '/'로 변경
//            .and()
//                .logout()
//                    .logoutSuccessUrl("/main") // 로그아웃 성공 시 '/'로 리디렉션 변경
//            .and()
//                .csrf().disable() // CSRF 보호 기능 비활성화
//                .cors().disable() // CORS 방지
//                .headers().frameOptions().disable(); // Clickjacking 방지를 위한 설정 비활성화
//        
//        return httpSecurity.build();
//    }

//    @Bean
//    //스프링 시큐리티의 인증을 담당, 사용자 인증시 앞에서 작성한 UserSecurityService 와 PasswordEncoder 를 사용
//    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//        return authenticationConfiguration.getAuthenticationManager();
//    }
}
