package com.zss.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Stephen
 * @since 2017-11-03
 */

@EnableSwagger2
@Configuration
public class SwaggerConfig {


    @Bean
    public Docket createRestApi() {

        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        docket.apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.zss.user.controller"))
            .paths(PathSelectors.any())
            .build();
        return docket;
    }

    private ApiInfo apiInfo() {
    	return new ApiInfoBuilder()
				.title("用户服务 接口")
				.description("用户服务API")
				.termsOfServiceUrl("")
				.contact("user")
				.version("1.0")
				.build();
    }
}
