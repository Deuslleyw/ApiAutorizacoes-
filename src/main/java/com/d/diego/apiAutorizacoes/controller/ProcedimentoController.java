package com.d.diego.apiAutorizacoes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/procedimento/{procedimento}/idade/{idade}/sexo/{sexo}")
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
