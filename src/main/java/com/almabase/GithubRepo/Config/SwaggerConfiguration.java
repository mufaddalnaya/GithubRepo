package com.almabase.GithubRepo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


/*
Swagger Config Class FOr Documentation Purpose
 */

@EnableSwagger2
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.almabase.GithubRepo"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
    }
    private ApiInfo getApiInfo(){
        return new ApiInfo(
                "Almabase Spring Boot Project",
                "App to get the most popular repository of any organisation and its best contributors",
                "1.0.0",
                "Terms of Service",
                new Contact("Mufaddal Naya", "", "mufaddal.naya@gmail.com"),
                "",
                "",
                Collections.emptyList());
    }

}
