package com.zhou.apigateway;

import com.zhou.apigateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * 能够作为系统的统一入口，屏蔽了系统内部各个微服务的细节
 * 能够和服务治理框架结合，实现自动化的服务实例维护一级负载均衡的路由转发
 * 能够实现接口权限家宴和为服务业务逻辑的解耦
 * 通过服务网关中的过滤器，在各生命周期中去校验请求的内容，将原本在对外服务层要做的校验前移
 */
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
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
    }
}
