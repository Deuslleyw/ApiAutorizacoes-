package com.d.diego.apiAutorizacoes.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@JsonIgnoreProperties("valid")
@Getter
@Setter
@Entity
@Table(name = "PROCEDIMENTOS", uniqueConstraints = @UniqueConstraint(columnNames = { "cod_procedimento", "idade", "sexo" },
        name = "cod_procedimento"))
public class Procedimento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cod_procedimento", nullable=false)
    private Integer procedimento;

    @Column(name = "idade", nullable=false)
    private Integer idade;

    @Enumerated(EnumType.STRING)
    @Column(name = "sexo", length = 1, nullable=false)
    private Sexo sexo;

    @Enumerated(EnumType.STRING)
    @Column(name = "permitido", length = 3, nullable=false)
    private Autorizacao autoriza;

    public Procedimento(Integer procedimento, Integer idade, Sexo sexo, Autorizacao autoriza) {
        this.procedimento = procedimento;
        this.idade = idade;
        this.sexo = sexo;
        this.autoriza = autoriza;
    }

    public boolean isValid() {
        if(procedimento != null && idade != null && sexo != null && autoriza != null) {
            return true;
        }
        return false;
    }
}
