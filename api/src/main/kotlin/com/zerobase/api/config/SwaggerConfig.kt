package com.zerobase.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig {
    // http://localhost:80/swagger-ui/index.html

    @Bean
    fun swaggerApi(): Docket = Docket(DocumentationType.OAS_30)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.zerobase.api"))
        .paths(PathSelectors.any())
        .build()
        .useDefaultResponseMessages(false)

    private fun apiInfo() = ApiInfoBuilder()
        .title("Swagger")
        .description("fintech")
        .version("1.0")
        .build()
}