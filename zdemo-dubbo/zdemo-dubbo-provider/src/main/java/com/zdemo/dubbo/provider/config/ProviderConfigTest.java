package com.zdemo.dubbo.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ProviderConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.AnnotationBean;

@Configuration
public class ProviderConfigTest {

	// 当前应用配置
	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig applicationConfig = new ApplicationConfig();
		applicationConfig.setName("yyy");
		return applicationConfig;
	}
		
	// 连接注册中心配置
	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig registryConfig =new RegistryConfig();
		registryConfig.setAddress("zookeeper://192.168.0.250:2181");
		return registryConfig;
	}	
	
	@Bean
	public AnnotationBean annotationBean() {
		AnnotationBean annotationBean = new AnnotationBean();
		annotationBean.setPackage("com.zdemo.dubbo.provider.config");
		return annotationBean;
	}
	
	@Bean
	public ProviderConfig providerConfig() {
		ProviderConfig providerConfig = new ProviderConfig();
		providerConfig.setToken(true);
		return providerConfig;
	}
}
