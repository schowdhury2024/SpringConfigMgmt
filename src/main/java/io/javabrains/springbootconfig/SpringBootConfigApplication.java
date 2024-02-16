package io.javabrains.springbootconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication // (scanBasePackages={"io.javabrains.springbootconfig.profileExperiment","io.javabrains.springbootconfig"})
// @ComponentScan({"io.javabrains.springbootconfig.profileExperiment", "io.javabrains.springbootconfig"})
public class SpringBootConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigApplication.class, args);

		System.out.println("~~~~~~~ Level 3 -- Configuration & Management ~~~~~~~~");
	}

}
