package com.example.hotel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;

@MapperScan(basePackages = {"com.example.hotel.mappers","com.example.hotel.mappers"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HotelApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(HotelApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

}
