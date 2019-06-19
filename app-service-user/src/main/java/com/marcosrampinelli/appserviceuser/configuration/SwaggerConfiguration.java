package com.marcosrampinelli.appserviceuser.configuration;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
        		.apis(RequestHandlerSelectors.basePackage("com.marcosrampinelli.appserviceuser"))
        		.paths(PathSelectors.ant("/api/**"))
        		.build()
        		.apiInfo(apiInfo())
        		
        		.globalResponseMessage(RequestMethod.GET, 
        			Arrays.asList(
        				new ResponseMessageBuilder()
        					.code(500)
        					.message("Ops! It's an internal errror.")
        					.build(),
        				new ResponseMessageBuilder()
        					.code(403)
        					.message("Forbidden! You can't access this resource.")
        					.build(),
        				new ResponseMessageBuilder()
        					.code(404)
        					.message("The resource that you're looking for was not found.")
        					.build()));
    }
	
	private ApiInfo apiInfo() {
		Contact contato = new Contact("Marcos Rampinelli", 
				"https://www.linkedin.com/in/marcos-rampinelli/", "marcosrampinelli@gmail.com");
		
		return new ApiInfoBuilder()
				.title("AppServiceUser - API Documentation")
				.description("This is an interactive documentation of Rest API. You should try some request.")
				.version("1.0")
				.contact(contato)
				.build();		
	}
}
