package org.rest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurationSupport {
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.useDefaultResponseMessages(false)
                .select().apis(RequestHandlerSelectors.basePackage("org.rest.controller"))
                .build();
             
    }
	
	@Bean
	public Docket productApiV1() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("API V1")
				.useDefaultResponseMessages(false)
				.select().apis(RequestHandlerSelectors.basePackage("org.rest.v1.controller")).paths(PathSelectors.regex("/v1/*.*"))
                .build();
	}
	
	@Bean
	public Docket productApiV2() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("API V2")
				.useDefaultResponseMessages(false)
				.select().apis(RequestHandlerSelectors.basePackage("org.rest.v2.controller")).paths(PathSelectors.regex("/v2/*.*"))
                .build();
	}
	
	@Bean
	public Docket productApiV3() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("API V3")
				.useDefaultResponseMessages(false)
				.select().apis(RequestHandlerSelectors.basePackage("org.rest.v3.controller")).paths(PathSelectors.regex("/v3/*.*"))
                .build();
	}
	
	@Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
 
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        
    }
}
