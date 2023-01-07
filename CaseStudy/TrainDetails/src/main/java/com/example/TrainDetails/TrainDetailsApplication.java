package com.example.TrainDetails;


//import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class TrainDetailsApplication {
	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(TrainDetailsApplication.class, args);
		
	}	
	
	}



