package com.d.diego.apiAutorizacoes.controller;


import com.d.diego.apiAutorizacoes.domain.Procedimento;
import com.d.diego.apiAutorizacoes.enums.Autorizacao;
import com.d.diego.apiAutorizacoes.enums.Sexo;
import com.d.diego.apiAutorizacoes.repository.ProcedimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autorizador")
public class ProcedimentoController {

    @Autowired
    private ProcedimentoRepository procedimentoRepositorio;

    @GetMapping
    public List<Procedimento> listar(){
        return procedimentoRepositorio.findAll();
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/cadastro/procedimento/{procedimento}/idade/{idade}/sexo/{sexo}/autoriza/{autoriza}")
    public ResponseEntity<Procedimento> cadastroProcedimento(@PathVariable("procedimento") Integer procedimento, @PathVariable("idade") Integer idade,
                                                             @PathVariable("sexo") String sexo, @PathVariable("autoriza") String autoriza) {
        try {
            Sexo sex = Sexo.valueOf(sexo);
            Autorizacao autorizador = Autorizacao.valueOf(autoriza);

            Procedimento novoProcedimento = new Procedimento(procedimento, idade, sex, autorizador);

            Procedimento procedimentoSalvo = procedimentoRepositorio.save(novoProcedimento);

            return ResponseEntity.ok(procedimentoSalvo);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }
    }

    @GetMapping("/autorizador/procedimento/{procedimento}/idade/{idade}/sexo/{sexo}")
    public ResponseEntity<Autorizacao> buscaProcedimento(@PathVariable("procedimento") Integer procedimento, @PathVariable("idade") Integer idade,
                                                         @PathVariable("sexo") String sexo) {
        try {
            Sexo sex = Sexo.valueOf(sexo);

            Autorizacao autoriza = procedimentoRepositorio.getAutoriza(procedimento, idade, sex);

            autoriza = autoriza != null ? autoriza : Autorizacao.NAO;

            return ResponseEntity.ok(autoriza);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
        }


    }

}
