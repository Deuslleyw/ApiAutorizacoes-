package com.d.diego.apiAutorizacoes.controller;


import com.d.diego.apiAutorizacoes.domain.UserAuth;
import com.d.diego.apiAutorizacoes.services.JwtService;
import com.d.diego.apiAutorizacoes.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UsuarioController {

    private final UserService usuarioService;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> autenticar(@RequestBody UserAuth user) {
        try {
            usuarioService.autenticar(user);
            String token = jwtService.generateToken(user);
            return ResponseEntity.ok("Login efetuado com sucesso \ntoken: " + token);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Usuario ou Senha invalido.");
        }

    }
}
