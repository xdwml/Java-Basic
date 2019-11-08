package edu.xidian.day04.demo01.demo02;

public class Demo02methodDefine {
    public static void main(String[] args) {
        //单独调用
        sum(10,20);
        System.out.println("====================");
        //打印调用
        System.out.println(sum(10,20));
        System.out.println("====================");
        //赋值调用
        int result=sum(15,25);
        System.out.println("变量的值："+result);
    }
    public static int sum(int  a,int b){
        System.out.println("方法执行啦");
        int result =a+b;
        return result;
    }
}
