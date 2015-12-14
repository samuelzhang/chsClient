/**
 * 
 */
package cn.com.rainet.ChsClient;

import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.rainet.chs.service.HelloWorldService;

/**
 * @author wyh
 *
 */
public class HelloWorldTest {
	private HelloWorldService helloWorldService;
	@Before
	public void before(){
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:applicationConsumer.xml"});
        helloWorldService = (HelloWorldService)context.getBean("helloWorldService");
	}
	@org.junit.Test
	public void testSayHello(){
		System.out.println(helloWorldService.sayHello("ygs"));
	}
}
