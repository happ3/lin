package com.zdemo.dubbo.provider.config;

import com.alibaba.dubbo.config.annotation.Service;
import com.zdemo.inte.DPService;

@Service(version="1.0.0")
public class DPServiceImpl  implements DPService{

	@Override 
	public String getName(String name) {
		System.out.println(name);
		return name;
	}

}
