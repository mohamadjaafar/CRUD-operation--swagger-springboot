package com.example.youtabJavaTest.swaggerconfig;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicates;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRules;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Class contains needed Swagger configuration
 *
 */
@Slf4j
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket apiDocket() {
        TypeResolver typeResolver = new TypeResolver();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .alternateTypeRules(AlternateTypeRules.newRule(LocalDate.class, Date.class))
                .alternateTypeRules(AlternateTypeRules.newRule(
                        typeResolver.resolve(List.class, LocalDate.class),
                        typeResolver.resolve(List.class, Date.class), Ordered.HIGHEST_PRECEDENCE))
                .select()
                .apis(Predicates.or(
                        RequestHandlerSelectors.basePackage("com.example.youtabJavaTest")))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(getApiInfo());
        log.debug("Docket initialized");
        return docket;
    }

    private ApiInfo getApiInfo() {
        ApiInfo apiInfo = new ApiInfo(
                "YouTap Java Test",
                "Microservice that provides details of a single user",
                "0.0.1-SNAPSHOT",
                "Terms of Service",
                null,
                "",
                "",
                Collections.emptyList());
        log.debug("ApiInfo initialized");
        return apiInfo;
    }


}

