package com.dwalter.baseproject.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;

class Swagger {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info().title("Goji order service exercise REST API")
                .description("REST API Goji Order Service")
                .version("v0.0.1")
                .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                .contact(contact());
    }

    private Contact contact() {
        Contact contact = new Contact();
        contact.name("Dawid Walter");
        contact.email("davedohc@aim.com");
        return contact;
    }
}
