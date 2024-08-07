//package com.example.chat.config;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import io.swagger.v3.oas.models.servers.Server;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SwaggerConfig {
//    @Bean
//    public OpenAPI customOpenAPI() {
//        String jwt = "JWT";
//        SecurityRequirement securityRequirement = new SecurityRequirement().addList(jwt);
//        Components components = new Components().addSecuritySchemes(jwt, new SecurityScheme()
//                .name(jwt)
//                .type(SecurityScheme.Type.HTTP)
//                .scheme("Bearer")
//                .bearerFormat("JWT")
//        );
//        Server server = new Server().url("/");
//        return new OpenAPI()
//                .components(new Components())
//                .info(apiInfo())
//                .addSecurityItem(securityRequirement)
//                .addServersItem(server)
//                .components(components);
//
//    }
//    private Info apiInfo() {
//        return new Info()
//                .title("chat test swagger")
//                .description("test")
//                .version("1.0.0");
//    }
//}
