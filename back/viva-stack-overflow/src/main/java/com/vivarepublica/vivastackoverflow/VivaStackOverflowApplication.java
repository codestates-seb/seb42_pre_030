package com.vivarepublica.vivastackoverflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class VivaStackOverflowApplication {

	public static void main(String[] args) {
		SpringApplication.run(VivaStackOverflowApplication.class, args);
	}

}
