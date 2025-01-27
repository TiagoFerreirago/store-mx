package com.mx.product_catalog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	
	@Bean
	public OpenAPI customOpenApi() {
		
		return new OpenAPI()
				.info(new Info()
						.title("REST API's with Java 17, Spring Boot 3.4.1 and Redis")
						.version("v1")
						.description("API for product management, allowing you to add new products to the system and search for detailed information on registered products.")
						.termsOfService("https://www.mx.com/shopping")
						.license(new License()
								.name("apache 2.0")
								.url("https://www.mx.com/licenses")));
	}
}
