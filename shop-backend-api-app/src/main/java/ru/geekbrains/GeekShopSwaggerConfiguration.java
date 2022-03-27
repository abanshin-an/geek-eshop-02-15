package ru.geekbrains;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
//https://github.com/swagger-api/swagger-core/wiki/
//https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---Annotations
@Configuration
public class GeekShopSwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(
                        new Info().title("Application REST API")
                                .version("1.0-SNAPSHOT")
                                .description("Geekbrains shop backend services")
                                .license(new License().name("Apache 2.0")
                                        .url("http://springdoc.org"))
                                .contact(new Contact().name("username")
                                        .email("a2n9@mail.ru")))
                .servers(List.of(new Server().url("http://localhost:8080")
                                .description("Dev service"),
                        new Server().url("http://localhost:8082")
                                .description("Beta service")));
    }

}
