package com.taotao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TestMapper;
import com.taotao.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	//1、注入mapper
	@Autowired
	private TestMapper mapper;
	@Override
	public String queryNow() {
		
		//2、调用mapper的方法 返回
		return mapper.queryNow();
	}

}
