package com.zdemo.dubbo.consumer.config;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zdemo.inte.DPService;


@RestController
public class TestController {
	
	@Reference(version="1.0.0")
	DPService dpService;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(){
		dpService.getName("ok");
		return "ok";
	}

}
