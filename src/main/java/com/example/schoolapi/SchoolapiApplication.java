package com.example.schoolapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@SpringBootApplication
@EnableSwagger2
public class SchoolapiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SchoolapiApplication.class, args);
	}
	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SchoolapiApplication.class);
	}*/
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.schoolapi"))
				.build()
		        .apiInfo(apiDetails());
	}
	private ApiInfo apiDetails(){
		return new ApiInfo(
            "College Service API",
				"Sample REST API using Spring Boot",
				"1.0",
				"",
				 new Contact("Krishna","",""),
				"Free",
				"",
                 Collections.emptyList()
		);
	}
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
