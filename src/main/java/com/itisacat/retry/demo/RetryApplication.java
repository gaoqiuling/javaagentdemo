package com.itisacat.retry.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication(scanBasePackages = "com.itisacat.retry.demo")
@EnableRetry
public class RetryApplication {
	public static void main(String[] args) {
		SpringApplication.run(RetryApplication.class, args);
	}
}
