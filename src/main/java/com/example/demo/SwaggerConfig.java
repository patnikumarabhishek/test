package com.example.demo;

/**
 * Created by sumit.nagariya on 15/07/20.
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
   @Bean
   public Docket api() {
      ParameterBuilder paramBuilder = new ParameterBuilder();
      List<Parameter> params = new ArrayList<>();
      return new Docket(DocumentationType.SWAGGER_2).globalOperationParameters(params)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
            .paths(PathSelectors.any())
            .build();
   }
}
