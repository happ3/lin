package com.zdemo.dubbo.consumer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(locations = "classpath:dubbo.properties", prefix = "dubbo", ignoreUnknownFields = true)
public class DubboParam {

	public static String applicationName;
	
	public static String zk_address;
	
	public static String dubbo_protocol;
	

	public static void setApplicationName(String applicationName) {
		DubboParam.applicationName = applicationName;
	}

	public static void setZk_address(String zk_address) {
		DubboParam.zk_address = zk_address;
	}

	public static void setDubbo_protocol(String dubbo_protocol) {
		DubboParam.dubbo_protocol = dubbo_protocol;
	}

	
	
	
}
