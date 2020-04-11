package com.hungbia.shopweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.hungbia.shopweb" })
//@EntityScan(basePackages = { "com.hungbia.shopweb.entity" }) // neu nam trong pakage gốc thì k cần
public class ShopwebApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopwebApplication.class, args);
	}

}
