package com.zhou.apigateway;

import com.zhou.apigateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringCloudApplication
@EnableZuulProxy  //启动zuul的网关
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
//		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

	/**
	 * 配置自定义过滤器
	 */
	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}
}
