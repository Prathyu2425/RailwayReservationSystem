package com.example.TrainReservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2


@SpringBootApplication
@EnableEurekaClient
public class TrainReservationApplication {
	  @LoadBalanced
	  
	  @Bean public RestTemplate getRestTemplate() { return new RestTemplate(); }
	 	public static void main(String[] args) {
		SpringApplication.run(TrainReservationApplication.class, args);
	}

}
