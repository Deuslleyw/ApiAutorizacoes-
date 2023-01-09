package com.d.diego.apiAutorizacoes.repository;

import com.d.diego.apiAutorizacoes.domain.Procedimento;
import com.d.diego.apiAutorizacoes.enums.Autorizacao;
import com.d.diego.apiAutorizacoes.enums.Sexo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {

    @Query(
            "SELECT p.autoriza "
                    + "FROM Procedimento p "
                    + "WHERE p.procedimento = ?1 "
                    + "AND p.idade = ?2 "
                    + "AND p.sexo = ?3 ")
    Autorizacao getAutoriza(Integer procedimento, Integer idade, Sexo sexo);


//	Optional<Autorizacao> findBysexoAndIdade(Sexo sexo, Integer idade);


}
