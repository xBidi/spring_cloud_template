package com.spring.auth.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.security.Principal;
import java.time.LocalDate;

/** @author diegotobalina created on 24/06/2020 */
@Configuration
@EnableSwagger2
public class SwaggerConfigurer {

  private String basePackage = "com.spring.auth"; // TODO REPLACE PACKAGE

  @Bean
  public Docket eDesignApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(getApiInfo())
        .ignoredParameterTypes(Principal.class)
        .enable(true)
        .select()
        .apis(RequestHandlerSelectors.basePackage(basePackage))
        .paths(PathSelectors.any())
        .build()
        .pathMapping("/")
        .directModelSubstitute(LocalDate.class, String.class)
        .genericModelSubstitutes(ResponseEntity.class)
        .useDefaultResponseMessages(false)
        .enableUrlTemplating(false);
  }

  @Bean
  UiConfiguration uiConfig() {
    return UiConfigurationBuilder.builder()
        .deepLinking(false)
        .displayOperationId(Boolean.FALSE)
        .defaultModelsExpandDepth(1)
        .defaultModelExpandDepth(1)
        .defaultModelRendering(ModelRendering.EXAMPLE)
        .displayRequestDuration(true)
        .docExpansion(DocExpansion.NONE)
        .filter(false)
        .maxDisplayedTags(0)
        .operationsSorter(OperationsSorter.ALPHA)
        .showExtensions(false)
        .tagsSorter(TagsSorter.ALPHA)
        .supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
        .validatorUrl(null)
        .build();
  }

  private ApiInfo getApiInfo() {
    return new ApiInfoBuilder()
        .title("title placeholder") // TODO REPLACE TITLE
        .description("description placeholder") // TODO REPLACE DESCRIPTION
        .version("v0") // TODO REPLACE VERSION
        .build();
  }
}
