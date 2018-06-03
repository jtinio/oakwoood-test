package com.oakwood.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@SpringBootApplication
@ComponentScan(basePackages = { "com.oakwood" })
@EntityScan(basePackages = { "com.oakwood.model" }, basePackageClasses = { Jsr310JpaConverters.class })
@EnableJpaRepositories(basePackages = { "com.oakwood.repository" })
public class ApplicationTest {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTest.class, args);
	}

}