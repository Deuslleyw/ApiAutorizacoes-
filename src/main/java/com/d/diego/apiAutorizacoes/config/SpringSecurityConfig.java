package com.d.diego.apiAutorizacoes.config;


import com.d.diego.apiAutorizacoes.jwt.JwtFilter;
import com.d.diego.apiAutorizacoes.services.JwtService;
import com.d.diego.apiAutorizacoes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
    public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        private UserService usuarioServiceImpl;

        @Autowired
        private JwtService jwtService;

        @Bean
        public PasswordEncoder encoder() {
            return new BCryptPasswordEncoder();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication()
                    .withUser("Diego").password("102030").roles("ADMIN")
                    .and()
                    .passwordEncoder(encoder());
        }

        @Bean
        public OncePerRequestFilter JwtFilter() {
            return new JwtFilter(jwtService, usuarioServiceImpl);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/api/auth/**" ).permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .addFilterBefore(JwtFilter(), UsernamePasswordAuthenticationFilter.class);
        }
}
