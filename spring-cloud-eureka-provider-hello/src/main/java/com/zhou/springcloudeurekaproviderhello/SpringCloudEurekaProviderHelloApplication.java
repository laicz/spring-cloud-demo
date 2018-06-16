package com.zhou.springcloudeurekaproviderhello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  //eureka注册端
public class SpringCloudEurekaProviderHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaProviderHelloApplication.class, args);
	}
}
