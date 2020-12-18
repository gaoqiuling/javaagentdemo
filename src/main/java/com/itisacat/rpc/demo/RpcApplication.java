package com.itisacat.rpc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication(scanBasePackages = "com.itisacat.rpc.demo")
@Import(RpcInitConfig.class)
public class RpcApplication {
	public static void main(String[] args) {
		SpringApplication.run(RpcApplication.class, args);
	}
}
