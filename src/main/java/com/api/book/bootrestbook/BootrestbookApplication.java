package com.api.book.bootrestbook;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
public class BootrestbookApplication {


	public static void main(String[] args) {
		SpringApplication.run(BootrestbookApplication.class, args);
		System.out.println("spring boot project started.......................................................");
	}
	@Bean
	public WebMvcConfigurer configure(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry reg){
				reg.addMapping("/**").allowedOrigins("*");
			}
			
		};
		
	}


	

}
