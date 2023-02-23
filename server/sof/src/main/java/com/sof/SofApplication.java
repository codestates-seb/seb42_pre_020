package com.sof;

import com.sof.Users.Controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sof.Users.Mapper.UserMapper"})
public class SofApplication {

	public static void main(String[] args) {
		SpringApplication.run(SofApplication.class, args);
	}

}
