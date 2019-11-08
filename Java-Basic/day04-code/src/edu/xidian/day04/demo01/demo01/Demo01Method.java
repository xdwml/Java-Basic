package edu.xidian.day04.demo01.demo01;

import java.lang.reflect.Method;

public class Demo01Method {
    public static void main(String[] args) {
        Method();
    }
    public static void  Method(){
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <5; j++) {
                System.out.print("   "+i+"*"+j+"="+i*j);
            }
            System.out.println();
        }

    }

}
