package edu.xidian.day04.demo01.demo04;
/*
方法的重载：参数类型相同
 */
public class demo01MethodOverload {
    public static void main(String[] args) {
        System.out.println(sum(2,3));
        System.out.println(sum(2,3,4));
    }
    public static int sum(int a,int b){
        System.out.println("两个参数的方法");
        return a+b;
    }
    public static int sum(int a,int b,int c){
        System.out.println("三个参数的方法");
        return a+b+c;
    }
}
