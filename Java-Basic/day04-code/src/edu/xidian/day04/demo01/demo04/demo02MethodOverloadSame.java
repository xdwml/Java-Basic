package edu.xidian.day04.demo01.demo04;
/*
方法的重载：参数类型相同
 */
public class demo02MethodOverloadSame {
    public static void main(String[] args) {
        byte a=10;
        byte b=20;
        System.out.println(isSame(a,b));
        System.out.println(isSame((short)20,(short)20));
        System.out.println(isSame(11,12));
        System.out.println(isSame(10l,10L));
    }
    public static boolean isSame(byte a,byte b){
        System.out.println("两个byte参数的方法");
        boolean same;
        if(a==b){
            same=true;
        }else{
            same=false;
        }
        return same;
    }
    public static boolean isSame(short a,short b){
        System.out.println("两个short参数的方法");
        boolean same;
        if(a==b){
            same=true;
        }else{
            same=false;
        }
        return same;
    }
    public static boolean isSame(int a,int b){
        System.out.println("两个int参数的方法");
        boolean same;
        if(a==b){
            same=true;
        }else{
            same=false;
        }
        return same;
    }
    public static boolean isSame(long a,long b){
        System.out.println("两个long参数的方法");
        boolean same;
        if(a==b){
            same=true;
        }else{
            same=false;
        }
        return same;
    }

}
