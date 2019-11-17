package edu.xidian.annotation;
@MyAnno(age=1,name="sjsjj",per=Person.P1,anno2 = @MyAnno2,strs={"asd","shdg"})
@MyAnno3
public class Worker{
    //@MyAnno3//不能加载方法上，报错
    public String name="add";

    //@MyAnno3//不能加载方法上，报错
    public void show(){

    }

}
