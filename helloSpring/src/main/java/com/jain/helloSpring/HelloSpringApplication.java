package com.jain.helloSpring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;










@EnableSwagger2
@SpringBootApplication
public class HelloSpringApplication {
	private static final Logger logger = LoggerFactory.getLogger(HelloSpringApplication.class);
	
	
	public static void main(String[] args) {
		
		logger.error("Welcome*************************");
		SpringApplication.run(HelloSpringApplication.class, args);
		
		
		
	}
	
	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.jain.helloSpring"))
	         .build()
	         .apiInfo(metaData());
	   }
	
	private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Hello Spring APi's")
                .description("\"Spring Boot REST API by Kunal\"")
                .version("1.0.0")
                
                .contact(new Contact("Kunal Jain", "Kunaljain.confluence.com","john@springfrmework.guru"))
                .build();
	}
	
}