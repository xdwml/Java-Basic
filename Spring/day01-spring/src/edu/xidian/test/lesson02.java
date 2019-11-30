package edu.xidian.test;

import edu.xidian.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class lesson02 {
    @Test
    public void test1() {
        //以前用UserService方式
        /*UserService userService = new UserServiceImpl();
        /*userService.add();*/
        //现在从Spring容器中获取
        //1.加载beans.xml，这个Spring的配置文件,内部就会创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //2.从spring容器获取userService对象
        UserService userService1 = (UserService) context.getBean("userService");  //强制转换
        userService1.add();
        

        UserService userService2 = (UserService) context.getBean("userService");  //强制转换
        userService2.add();

        System.out.println(userService1);
        System.out.println(userService2);
    }

}
