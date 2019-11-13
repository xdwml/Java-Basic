package edu.xidian.test;

import edu.xidian.junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalcutorTest {
    /*
    初始化方法：
        用于资源申请，所有测试方法在执行之前都会先执行该方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }
    /*
    释放资源方法：
        在所有测试方法执行完后，都会自动执行该方法
     */
    @After
    public void close(){
        System.out.println("close....");
    }
    /*
    测试add方法
     */
    @Test
    public void testAdd(){
        System.out.println("加法被执行啦");
        //1.创建计算器对象
        Calculator c=new Calculator();
        //2.调用add方法
        int result = c.add(1,3);
        System.out.println(result);
        //3.断言  我断言这个结果是4
        Assert.assertEquals(4,result);
    }
    /*
    测试sub方法
     */
    @Test
    public void testSub(){
        System.out.println("减法被执行啦");
        //1.创建计算器对象
        Calculator c=new Calculator();
        //2.调用sub方法
        int result = c.sub(1,3);
        System.out.println(result);
        //3.断言  我断言这个结果是-2
        Assert.assertEquals(-2,result);
    }
}
