package com.personalblog.personalblog.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springBlogOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Personal Blog Spring Boot API")
                        .description("Documentação da API do Blog Pessoal")
                        .version("v0.0.1")
                        .contact(new Contact()
                                .name("Vinicius Rodrigues")
                                .email("seuemail@exemplo.com")
                                .url("https://github.com/seu-usuario"))
                );
    }

    @Bean
    public OpenApiCustomizer customerGlobalHeaderOpenApiCustomiser() {
        return openApi -> {
            openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
                ApiResponses apiResponses = operation.getResponses();
                apiResponses.addApiResponse("200", createApiResponse("Sucesso!"));
                apiResponses.addApiResponse("201", createApiResponse("Criado!"));
                apiResponses.addApiResponse("204", createApiResponse("Sem Conteúdo!"));
                apiResponses.addApiResponse("400", createApiResponse("Erro na requisição!"));
                apiResponses.addApiResponse("401", createApiResponse("Não autorizado!"));
                apiResponses.addApiResponse("403", createApiResponse("Proibido!"));
                apiResponses.addApiResponse("404", createApiResponse("Não encontrado!"));
                apiResponses.addApiResponse("500", createApiResponse("Erro no servidor!"));
            }));
        };
    }

    private ApiResponse createApiResponse(String message) {
        return new ApiResponse().description(message);
    }
}