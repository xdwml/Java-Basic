package edu.xidian.test;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;


public class lesson03 {
    @Test
    public void test1() {
        /*
        装配bean的三种方式，所谓的装配bean就是在xml写一个bean标签
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
