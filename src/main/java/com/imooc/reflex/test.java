package com.imooc.reflex;
import org.junit.jupiter.api.Test;
import org.junit.*;

import java.util.Scanner;

public class test {
    @Test
    /**
     * 加载类的方式分为：
     * 静态加载：编译得时候加载可能要用到得类
     * 动态加载：运行时再加载
     *
     */

    /**
     * 静态加载在编译的时候加载,例如本例下面，如果没有Student
     * 就会报错，但是我有Person类，我输入Person也不能过编译
     * 动态加载就可以避免这种情况（也就是使用反射的方法）
     * 静态加载引发的问题
     */
    public void test(){

        Scanner in = new Scanner(System.in);
        String chose = in.nextLine();
        if(chose.equals("Person")){
            Person p = new Person();
        }else if(chose.equals("Student")){
            Student t = new Student();
        }
//        else{
//            noExist no = new noExist();
//        }
    }

    /**
     * 使用动态加载，来解决上面这个问题
     *
     */
    @Test
    public void test1() throws Exception {
        Scanner in = new Scanner(System.in);
        String chose = in.nextLine();
        if(chose.equals("Person")){
            Person p = new Person();
        }else  if("noExist".equals(chose)){
            Class c = Class.forName("com.imooc.reflex.noExist");
            Object e = c.newInstance();
        }
    }


}
