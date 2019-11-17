package edu.xidian.annotation;

/**
 *
 * JDK中预定义的一些注解
 *  @Override：检测被该注解标注的方法是否是继承自父类（接口）的
 *  @Deprecated：该注解标注的内容，表示已过时
 *  @SuppressWarnings：压制警告
 */
public class AnnoDemo02 {
    @Override
    public String toString() {
        return super.toString();
    }
    @Deprecated
    public void show1(){
        //有缺陷
    }
    @SuppressWarnings("all")
    public void show2(){
        //替代show1方法
    }

    public void demo(){
        show1();//表示已过时
        //show2();
    }
}
