package com.ecommerce.customer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
//@EnableSwagger2
public class SwaggerConfig {
    private static final String TITLE = "shipping API";
    private static final String DESCRIPTION = "Descripcion API shipping";
    private static final String BASE_PACKAGE = "com.ecommerce.shipping";
    private static final String VERSION = "v1";
  //  @Bean
//    public Docket swagger() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
//                .build()
//                .forCodeGeneration(true)
//                .apiInfo(new ApiInfoBuilder().title(TITLE).description(DESCRIPTION).version(VERSION).build());
   // }
}
