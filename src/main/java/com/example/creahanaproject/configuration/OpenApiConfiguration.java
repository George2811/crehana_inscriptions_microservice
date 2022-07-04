package com.example.creahanaproject.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean(name = "CrehanaOpenApi")
    public OpenAPI creahanaOpenAPI(){
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Crehana Project - API")
                        .description("Creahna Project implementado con Spring boot RESTful service y documentado con spingdoc_openapi y OpenAPI 3.0 "));
    }
}