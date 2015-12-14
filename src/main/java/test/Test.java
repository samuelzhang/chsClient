package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.com.rainet.chs.service.HelloWorldService;

import cn.com.rainet.chs.service.CollectSearchEqtService;
import cn.com.rainet.chs.service.ControlService;
import cn.com.rainet.chs.service.RegisterService;
import cn.com.rainet.chs.service.SystemMngService;
import cn.com.rainet.scheduler.service.CollectEquDataService;

public class Test {
    private String hCode = "127.0.0.1";
    private HelloWorldService helloWorldService;
    private HelloWorldService collectSearchEqtService;
    private HelloWorldService controlService;
    private HelloWorldService registerService;
    private HelloWorldService systemMngService;
    private HelloWorldService collectEquDataService;
    
    Test() {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:applicationConsumer.xml"});
        helloWorldService = (HelloWorldService)context.getBean("helloWorldService"); 
        collectSearchEqtService = (HelloWorldService)context.getBean("collectSearchEqtService");
        controlService = (HelloWorldService)context.getBean("controlService");
        registerService = (HelloWorldService)context.getBean("registerService");
        systemMngService = (HelloWorldService)context.getBean("systemMngService");
        collectEquDataService = (HelloWorldService)context.getBean("collectEquDataService");
    }
    
    public void prepare() {
        
        // search equipments
        Object equipments = collectSearchEqtService.searchEquipment(hCode,4);
        // TODO print equipments to check structure
        System.out.println(equipments);
        
        // TODO separate equipments into different kind of lists
        
        // register equipments
        Object result = registerService.registerEquipments(hCode, 17, list);
        // TODO print result to check structure
        System.out.println(result);
        
        Object result = registerService.registerEquipments(hCode, 18, list);
        // TODO print result to check structure
        System.out.println(result);
        
        Object result = registerService.registerEquipments(hCode, 19, list);
        // TODO print result to check structure
        System.out.println(result);
        
        Object result = registerService.registerEquipments(hCode, 20, list);
        // TODO print result to check structure
        System.out.println(result);
        
    }
    
    public void collect() {
        Object result = collectSearchEqtService.getEqtData(hCode, size);
        // TODO print result to check structure
        System.out.println(result);
    }
    
    public void control() {
        
        // TODO prepare codeStr and equs
        // TODO print action result
        // open watering
        Object result = controlService.openOrCloseCollectEqt(hCode, 0, equs.size(), codeStr.toString());
        System.out.println(result);
        // close watering
        Object result = controlService.openOrCloseCollectEqt(hCode, 1, equs.size(), codeStr.toString());
        System.out.println(result);
        
        // TODO prepare codeStr and equs
        // TODO print action result
        // open fertilize
        Object result = controlService.openOrCloseFertilizerEqt(hCode, 0, equs.size(), codeStr.toString());
        System.out.println(result);
        // close fertilize
        Object result = controlService.openOrCloseFertilizerEqt(hCode, 1, equs.size(), codeStr.toString());
        System.out.println(result);
    }

    public void sayHello(){
        System.out.println(helloWorldService.sayHello("name"));
    }
    
    public static void main(String args[]) {
        Test test = new Test();
        test.prepare();
        test.collect();
        test.control();
    }
}
