package com.taotao.test.jedis;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.taotao.content.jedis.JedisClient;
@Ignore
public class TestJedisClient {
	@Test
	public void terstdanji() {
		//1、初始化spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-redis.xml");
		//2、获取实现类实例
		JedisClient bean = context.getBean(JedisClient.class);
		//3、调用方法操作
		bean.set("jedisClientkey11", "jedisClientvalue11");
		System.out.println(bean.get("jedisClientkey11"));
	}
}
