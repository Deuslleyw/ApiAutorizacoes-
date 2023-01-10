package com.d.diego.apiAutorizacoes.config.swagger;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;

@OpenAPIDefinition(info =
@Info(title = "Api Autorizacoes",
        version = "1.0",
        description = "Documentation of Api Autorizaçoes "))
public class OpenApiConfiguration {

    @Bean
    public OpenAPI customOpenApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("Api autorizações")
                        .version("1.0"));

    }}