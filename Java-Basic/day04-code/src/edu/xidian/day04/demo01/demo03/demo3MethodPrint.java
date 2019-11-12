package edu.xidian.day04.demo01.demo03;
/*
题目要求：
定义一个方法，用来打印指定次数的Helloworld
 */
public class demo3MethodPrint {
    public static void main(String[] args) {
        Print(5);
    }
    /*
    三要素：
    返回值类型:打印
    方法名称:Print
    参数列表：int n
     */
    public static void Print(int n){
        for (int i = 0; i <n; i++) {
            System.out.println("Hello,World!"+(i+1));
        }
    }
}
