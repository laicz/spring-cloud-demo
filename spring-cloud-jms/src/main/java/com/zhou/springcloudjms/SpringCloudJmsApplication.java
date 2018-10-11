package com.zhou.springcloudjms;

import com.google.common.collect.ImmutableSet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"com"})
@PropertySources(value = {
        @PropertySource(value = "classpath:mq.properties")
})
public class SpringCloudJmsApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringCloudJmsApplication.class, args);
        SpringApplication springApplication = new SpringApplication(SpringCloudJmsApplication.class);
        springApplication.setSources(ImmutableSet.of("classpath:spring/spring-root.xml"));
        springApplication.run(args);
    }
}
