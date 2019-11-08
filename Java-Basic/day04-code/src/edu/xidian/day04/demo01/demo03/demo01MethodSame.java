package edu.xidian.day04.demo01.demo03;
/*
题目要求：
定义一个方法，判断两个数字是否相同
 */
public class demo01MethodSame {
    public static void main(String[] args) {
        System.out.println(isSame(5,10));

    }
    /*
    三要素
    返回值类型：boolean
    方法名称：isSame
    参数列表：int a,int b
     */
    public static boolean isSame(int a,int b){
        /*if(a==b){
            return true;
        }else{
            return false;
        }*/
        boolean same = a == b ? true:false;
        //return a==b;
    }
}
