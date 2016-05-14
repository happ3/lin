package com.zdemo.dubbo.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
@EnableConfigurationProperties
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages = "com.zdemo.dubbo.*")
public class App {
	
	
    public static void main( String[] args ){
        System.out.println( "Hello World!" );
        SpringApplication springApplication =new SpringApplication(App.class);
        springApplication.run(args);
    }

}
