package org.example.UserMicroservice;

import org.example.CoreLibrary.test.CoreTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class UserMicroserviceApplication {

	public static void main(String[] args) {
		CoreTest core = new CoreTest();

		SpringApplication.run(UserMicroserviceApplication.class, args);
	}

}
