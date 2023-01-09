package com.d.diego.apiAutorizacoes.jwt;

import com.d.diego.apiAutorizacoes.services.JwtService;
import com.d.diego.apiAutorizacoes.services.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    JwtService jwtService;
    UserService usuarioServiceImpl;

    public JwtFilter(JwtService jwtService, UserService usuarioServiceImpl) {
        super();
        this.jwtService = jwtService;
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    @Override
    protected void
    doFilterInternal(HttpServletRequest request,
                     HttpServletResponse response,
                     FilterChain filterChain)
            throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");

        if(authorization != null && authorization.startsWith("Bearer")) {
            String token = authorization.split(" ")[1];
            boolean isTokenValido = jwtService.tokenValido(token);

            if(isTokenValido) {
                String login = jwtService.obterLoginUsuario(token);
                UserDetails usuario = usuarioServiceImpl.loadUserByUsername(login);


                UsernamePasswordAuthenticationToken user = new
                        UsernamePasswordAuthenticationToken
                        (usuario, null, usuario.getAuthorities());

                user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(user);
            }
        }
        filterChain.doFilter(request, response);
    }
}
