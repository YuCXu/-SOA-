package com.taotao.test.jedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
@Ignore
public class TestJedis {
	
	//测试单机版
	@Test
	public void testJedis() {
		//1、创建jedis对象，需要指定连接的地址和端口
		Jedis jedis = new Jedis("192.168.25.128",6379);
		//2、直接操作redis  set
		jedis.set("key2", "value2");
		System.out.println(jedis.get("key2"));
		//3、关闭jedis
		jedis.close();
	}
	
	@Test
	public void testJedisPool() {
		//1、创建jedispool，对象需要指定端口和地址
		JedisPool jedisPool = new JedisPool("192.168.25.128",6379);
		//2、获取jedis的对象
		Jedis jedis = jedisPool.getResource();
		//3、直接操作redis
		jedis.set("keypool", "pool");
		System.out.println(jedis.get("keypool"));
		//4、关闭redis，释放资源到连接池中
		jedis.close();
		//5、关闭连接池（在应用系统关闭时才关闭）
		jedisPool.close();
	}
	
	//测试集群版
	@Test
	public void testJedisCluster() {
		Set<HostAndPort> nodes = new HashSet<>();
		nodes.add(new HostAndPort("192.168.25.128",7001));
		nodes.add(new HostAndPort("192.168.25.128",7002));
		nodes.add(new HostAndPort("192.168.25.128",7003));
		nodes.add(new HostAndPort("192.168.25.128",7004));
		nodes.add(new HostAndPort("192.168.25.128",7005));
		nodes.add(new HostAndPort("192.168.25.128",7006));
		//1、创建jediscluster对象
		JedisCluster cluster = new JedisCluster(nodes);
		//2、直接根据jediscluster对象操作redis集群
		cluster.set("keycluster", "cluster value");
		System.out.println(cluster.get("keycluster"));
		//3、关闭jediscluster对象（是在应用系统关闭的时候关闭） 封装了连接池
		cluster.close();
	}
}
