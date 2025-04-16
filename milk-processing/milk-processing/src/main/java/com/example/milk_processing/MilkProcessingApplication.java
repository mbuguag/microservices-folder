package com.example.milk_processing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Enable Feign Client support
public class MilkProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MilkProcessingApplication.class, args);
	}

}
