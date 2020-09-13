package com.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//When packaging to jar
//java -jar *.jar --server.port=8081
//java -jar -Dspring.config.location = C:\application.properties *.jar 
// java -jar *.jar spring.profiles.active=dev

@SpringBootApplication
// OR
// @EnableAutoConfiguration
// @ComponentScan(basePackages = "com.springboot")
// @Configuation
public class SpringBootSpringMvcWarApp extends SpringBootServletInitializer {

	private static final Logger logger = LoggerFactory.getLogger(SpringBootSpringMvcWarApp.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootSpringMvcWarApp.class);
	}

	public static void main(String[] args) {
		logger.error("this is a error message");
		SpringApplication.run(SpringBootSpringMvcWarApp.class, args);
		// OR
		// To disable banner
		// SpringApplication app = new
		// SpringApplication(SpringBootThymeleafWarApp.class);
		// app.setBannerMode(Banner.Mode.OFF);
	}

}
