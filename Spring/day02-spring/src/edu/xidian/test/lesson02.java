package edu.xidian.test;

import edu.xidian.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;


public class lesson02 {
    @Test
    public void test1() {
        /*
        BeanFactory采用延迟加载，第一次getBean时才会初始化Bean
        ApplicationContext是即时加载
        ApplicationContext是对BeanFactory扩展，提供了更多功能
            国际化处理
            事件传递
            Bean自动装配
            各种不同应用层的Context
         */

        //ClassPathXmlApplicationContext
        //ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");


        //BeanFactory(了解)
        String path="E:\\IDEA\\Spring\\day02-spring\\src\\beans.xml";
        BeanFactory factory=new XmlBeanFactory(new FileSystemResource(path));
        //UserService user = (UserService) factory.getBean("userService");
        //user.add();
    }

}
