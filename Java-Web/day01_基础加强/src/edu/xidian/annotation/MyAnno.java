package edu.xidian.annotation;

/**
 * 自定义注解
 */
public @interface MyAnno {
    int age();
    String name();
    String name2() default "zjamh";
    //String show2();
    Person per();
    MyAnno2 anno2();
    String[] strs();
}
