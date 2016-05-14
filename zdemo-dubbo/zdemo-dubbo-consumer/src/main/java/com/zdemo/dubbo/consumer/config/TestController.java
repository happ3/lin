package com.zdemo.dubbo.consumer.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;


@RestController
public class TestController {
	
	@Reference(version="2.0.0")
	
	@RequestMapping(value="/tt",method=RequestMethod.GET)
	public String test(){
		return "ok";
	}

}
