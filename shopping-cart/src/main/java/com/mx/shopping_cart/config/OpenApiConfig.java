package com.mx.shopping_cart.config;

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
						.description("Some description about your API")
						.termsOfService("https://www.mx.com/shopping")
						.license(new License()
								.name("apache 2.0")
								.url("https://www.mx.com/licenses")));
	}
}
