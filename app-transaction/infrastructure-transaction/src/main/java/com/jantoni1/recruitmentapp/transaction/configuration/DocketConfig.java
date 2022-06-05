package com.jantoni1.recruitmentapp.transaction.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.Locale;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
class DocketConfig {
    @Bean
    public Docket getDocket(
            @Value("${spring.application.name}") String appName
    ) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.jantoni1.recruitmentapp"))
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(Timestamp.class, String.class)
                .directModelSubstitute(Locale.class, String.class)
                .apiInfo(apiInfo(appName));
    }

    private ApiInfo apiInfo(
             String appName
    ) {
        return new ApiInfo(
                appName,
                "",
                "1.0",
                null,
                new Contact("", "", "j.antoniak8@gmail.com"),
                null,
                null,
                Collections.emptyList()
        );
    }
}
