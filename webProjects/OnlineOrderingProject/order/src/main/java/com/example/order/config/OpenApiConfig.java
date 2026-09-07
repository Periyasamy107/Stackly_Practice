package com.example.order.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI onlineOrderingOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("Online Ordering System API")
                .version("1.0")
                .description("REST API for the Online Ordering System")
                .contact(new Contact()
                        .name("Online Ordering System"))

        );
    }

}
