package com.sas.tossabill.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    protected static final String TITLE = "Bills API REST";
    protected static final String DESCRIPTION = "API REST for financial control";
    protected static final String VERSION = "1.0";
    protected static final String LICENSE = "Apache License Version 2.0";
    protected static final String LICENSE_URL = "https://www.apache.org/licesen.html";
    protected static final String CONTACT_NAME = "Savio Amorim";
    protected static final String URL = "https://github.com/savioamorim/toss-a-bill";
    protected static final String EMAIL = "savioamorim.s@hotmail.com";

    @Bean
    public Docket productApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sas.tossabill"))
                .paths(regex("/bill.*"))
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        return new ApiInfoBuilder().title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .contact(new Contact(CONTACT_NAME, URL, EMAIL))
                .license(LICENSE)
                .licenseUrl(LICENSE_URL)
                .build();
    }
}
