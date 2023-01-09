package com.d.diego.apiAutorizacoes.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAuth {

    @NotEmpty(message = "Obrigatório")
    private String usuario;

    @NotEmpty(message = "Obrigatório")
    private String senha;

}
