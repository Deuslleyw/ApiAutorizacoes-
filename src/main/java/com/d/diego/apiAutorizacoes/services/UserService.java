package com.d.diego.apiAutorizacoes.services;

import com.d.diego.apiAutorizacoes.domain.UserAuth;
import com.d.diego.apiAutorizacoes.exceptions.SenhaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    public UserDetails autenticar(UserAuth usuario) {
        UserDetails user = loadUserByUsername(usuario.getUsuario());
        boolean senha = encoder.matches(usuario.getSenha(), user.getPassword());
        if(senha) {
            return user;
        }
        throw new SenhaInvalidaException();
    }

    @Override
    public UserDetails loadUserByUsername(String user){
        return User
                .builder()
                .roles("ADMIN")
                .username(user)
                .password(encoder.encode("12345"))
                .build();
    }
}
