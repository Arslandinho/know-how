package com.base.knowhow.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan("com.base.knowhow")
@EnableJpaRepositories("com.base.knowhow.repositories")
@EntityScan("com.base.knowhow")
@SpringBootApplication
//@EnableOAuth2Sso
public class KnowHowApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnowHowApplication.class, args);
	}
}
