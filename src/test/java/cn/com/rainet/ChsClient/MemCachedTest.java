/**
 * 
 */
package cn.com.rainet.ChsClient;

import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wyh
 *
 */
public class MemCachedTest {
	private MemcachedClient memcachedClient;
	@Before
	public void before(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-memcached.xml"});
		memcachedClient = (MemcachedClient)context.getBean("memcachedClient");
	}
	@Test
	public void test(){
		try {  
//            // 设置/获取  
//            memcachedClient.set("zlex", 36000, "set/get");  
//            assertEquals("set/get", memcachedClient.get("zlex"));  
//  
//            // 替换  
//            memcachedClient.replace("zlex", 36000, "replace");  
//            assertEquals("replace", memcachedClient.get("zlex"));  
//  
//            // 移除  
//            memcachedClient.delete("zlex");  
//            assertNull(memcachedClient.get("zlex"));  
			System.out.println(memcachedClient.get("test01"));
        } catch (TimeoutException e) {  
            e.printStackTrace();  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        } catch (MemcachedException e) {  
            e.printStackTrace();  
        }
	}
}
