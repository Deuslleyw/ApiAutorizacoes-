
https://github.com/Deuslleyw
# API AUTORIZAÇÃO DE PROCEDIMENTOS


## Documentação da API
A documentação da API foi criada utilizando o Swagger epode ser visualizada na url "/swagger-ui.html"

## 📦 Desenvolvimento

Utilizado Spring Boot seguindo os padrões Rest de Clean code e S.O.L.I.D.
Utilizado Spring Security com JWT para autenticação e autorização
Swagger para Documentação.

Projeto Lombok (Deve ser habilitado o plugin na IDE para funcionamento)

## 🛠️ Construído com

Ferramentas que utilizadas para criar o projeto

* [Intellij](https://www.jetbrains.com/pt-br/idea/) - IDE utilizada
* [SpringBoot](https://spring.io/projects/spring-boot) - Framework Java
* [Swagger](https://swagger.io/) - Documentação da API

-----------------------------------------------------------------------------

# EndPoints Exemplos

* PostMethod : localhost:8080: "/cadastro/procedimento/{procedimento}/idade/{idade}/sexo/{sexo}/autoriza/{autoriza}"

* GetMethod: localhost:8080: "/autorizador/procedimento/{procedimento}/idade/{idade}/sexo/{sexo}"

* Login: localhost:8080/"/api/auth"

* Usuario ("Testes")

* Senha Padrão ("12345")

-------------------------------------------------------------------------------
 # Banco de dados

* Utilizados : Postgres
* Utilize o ScriptSql disponivel na pasta (DB.migration) caso precise preencher as tabelas
