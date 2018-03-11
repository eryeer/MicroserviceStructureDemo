package com.wxbc;

import com.wxbc.security.service.*;
import com.wxbc.util.ReturnCode;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.session.ConcurrentSessionFilter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.session.ExpiringSession;
import org.springframework.session.FindByIndexNameSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.security.SpringSessionBackedSessionRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@SpringBootApplication
@RestController
@EnableZuulProxy
@MapperScan(basePackages = {"com.wxbc"})
public class UIApplication {
    @ResponseBody
    @RequestMapping("/loginsuccess")
    public Map<String, Object> loginsuccess() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "loginsuccess");
        return model;
    }

    @ResponseBody
    @RequestMapping("/loginfail")
    public Map<String, Object> loginfail() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("id", UUID.randomUUID().toString());
        model.put("content", "loginfail");
        return model;
    }

    public static void main(String[] args) {
        SpringApplication.run(UIApplication.class, args);
    }

    @Configuration
    @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
    @EnableWebSecurity
    //@EnableGlobalMethodSecurity(securedEnabled = true)
    protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Resource
        private SessionRegistry sessionRegistry;
        @Resource
        private CustomUserService customUserService;

        @Autowired
        private LoginProcessingFilter loginProcessingFilter;

        @Bean
        public SessionRegistry sessionRegistry() {
            return new SessionRegistryImpl();
        }

        @Bean
        public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
            return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
        }

        @Bean
        public LoginAuthenticationProvider frontAuthenticationProvider() {
            LoginAuthenticationProvider myAuthenticationProvider = new LoginAuthenticationProvider();
            myAuthenticationProvider.setUserDetailsService(customUserService);

            return myAuthenticationProvider;
        }

        @Bean
        public AuthenticationManager authenticationManager() {
            List<AuthenticationProvider> list = new ArrayList<>();
            list.add(frontAuthenticationProvider());
            AuthenticationManager authenticationManager = new ProviderManager(list);
            return authenticationManager;
        }

        @Bean
        public FrontAuthenticationFailureHandler frontAuthenticationFailureHandler() {
            return new FrontAuthenticationFailureHandler("/loginfail");
        }

        @Bean
        public FrontAuthenticationSuccessHandler frontAuthenticationSuccessHandler() {
            return new FrontAuthenticationSuccessHandler("/loginsuccess");
        }

        @Bean
        public LoginProcessingFilter validCodeProcessingFilter(AuthenticationManager authenticationManager) {
            LoginProcessingFilter filter = new LoginProcessingFilter();
            filter.setAuthenticationManager(authenticationManager);
            filter.setAuthenticationSuccessHandler(frontAuthenticationSuccessHandler());
            filter.setAuthenticationFailureHandler(frontAuthenticationFailureHandler());
            filter.setSessionAuthenticationStrategy(sessionStrategy());

            return filter;
        }

        @Bean
        public SessionAuthenticationStrategy sessionStrategy() {
            CustomSessionControlStrategy sessionStrategy = new CustomSessionControlStrategy(sessionRegistry());
            sessionStrategy.setMaximumSessions(1);
            sessionStrategy.setExceptionIfMaximumExceeded(false);
            return sessionStrategy;
        }


        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.formLogin().loginProcessingUrl("/login").and()
                    .authorizeRequests()
                    .antMatchers("/login", "/loginfail", "/loginsuccess","/logerror").permitAll()
                    .antMatchers("/resource/msg").hasAnyRole("ADMIN", "READER")
                    .anyRequest().authenticated()
                    .and()
                    .csrf().disable();

            http.addFilterBefore(loginProcessingFilter, UsernamePasswordAuthenticationFilter.class)
                    .formLogin().loginPage("/logerror");
            http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/logerror").deleteCookies("JSESSIONID");
            http.sessionManagement().invalidSessionUrl("/logerror");
            http.addFilterAt(new ConcurrentSessionFilter(sessionRegistry, sessionInformationExpiredStrategy()),
                    ConcurrentSessionFilter.class);
        }


        private SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
            return new SpecialSessionInformationExpiredStrategy(ReturnCode.SESSION_EXPIRED);
        }

        /*@Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                    .inMemoryAuthentication()
                    .withUser("user").password("password").roles("USER")
                    .and()
                    .withUser("admin").password("admin").roles("USER", "ADMIN", "READER", "WRITER")
                    .and()
                    .withUser("audit").password("audit").roles("USER", "ADMIN", "READER")
                    .and()
                    .withUser("reader").password("reader").roles("READER")
            ;

        }*/

    }
}


