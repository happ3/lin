package com.zdemo.dubbo.consumer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

@Configuration
public class ConsumerConfigTest {

	// 当前应用配置
	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName("xxx");
		return applicationConfig;
	}
	// 连接注册中心配置
	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig =new RegistryConfig();
		registryConfig.setAddress("zookeeper://192.168.0.250:2181");
		return registryConfig;
	}
	
	// 服务提供者协议配置
	@Bean
	public ProtocolConfig protocolConfig() {
		ProtocolConfig protocolConfig =new ProtocolConfig();
		protocolConfig.setName("dubbo");
		protocolConfig.setPort(12345);
		protocolConfig.setThreads(200);
		return protocolConfig;
	}
	
	
	@Bean
	public AnnotationBean annotationBean() {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage("com.zdemo.dubbo.consumer.config");
		return annotationBean;
	}
	
	
}
