package org.example.UserMicroservice;

import org.example.CoreLibrary.test.CoreTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserMicroserviceApplication {

	public static void main(String[] args) {
		CoreTest core = new CoreTest();

		SpringApplication.run(UserMicroserviceApplication.class, args);
	}

}
