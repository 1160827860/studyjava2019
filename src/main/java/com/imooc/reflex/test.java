package com.imooc.reflex;
import org.junit.jupiter.api.Test;
import org.junit.*;
import org.omg.CORBA.OBJ_ADAPTER;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class test {

    /**
     * 加载类的方式分为：
     * 静态加载：编译得时候加载可能要用到得类
     * 动态加载：运行时再加载
     */

    /**
     * 静态加载在编译的时候加载,例如本例下面，如果没有Student
     * 就会报错，但是我有Person类，我输入Person也不能过编译
     * 动态加载就可以避免这种情况（也就是使用反射的方法）
     * 静态加载引发的问题
     */
    @Test
    public void test(){


        String chose = "Student";
        if(chose.equals("Person")){
            Person p = new Person();
            p.toString();
        }else if(chose.equals("Student")){
            Student t = new Student();
            t.toString();
        }
//        else{
//            noExist no = new noExist();
//        }
    }

    /**
     * 使用动态加载，来解决上面这个问题
     * 虽然没有noExist类但是可以允许使用其他分支
     * 而第一个在编译阶段都过不去
     */
    @Test
    public void test1() throws Exception {
        String chose ="Person";
        if(chose.equals("Person")){
            Person p = new Person();
            System.out.println(p.toString());
        }else  if("noExist".equals(chose)){
            Class c = Class.forName("com.imooc.reflex.noExist");
            Object e = c.newInstance();
            e.toString();
        }
    }

    /**
     * java是面向对象编程的语言，所以全部都是对象
     * 类是不是对象？是谁的对象？
     * 类是对象，类是java.lang.Class类的实例对象
     *任何一个类都是Class的实例对象，这个实例对象有三种表示方式
     */
    @Test
    public void test2() throws ClassNotFoundException {
        /**
         * 说明每一个类中都有一个class静态变量
         */
        Class s = Student.class;

        /**
         * 每一个对象中可以调用getClass()方法获取本对象Class
         */
        Student a =new Student();

        Class s1 = a.getClass();
        /**
         * 知道类的路径可以使用Class的静态方法来获取类
         */
        Class s2 = Class.forName("com.imooc.reflex.Student");
        /**
         * 三种方法获取的类的类对象都是一样的
         */
        System.out.println(s1 == s2);

        System.out.println(s2 == s);
    }

    /**
     * 泛型只是为了防止编译过程中传入不符合自己定义泛型的对象(输入错误）
     * 还说明编译以后的泛型是去泛型化的，泛型只在编译阶段有效，反射会绕过编译
     * 底层存储还是用Object类型存储的，下面就来证明这个。
     * 这个例子就是往ArrayList<Interge>泛型中插入字符串
     */
    @Test
    public void test3() throws Exception {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(1);
        Class c = arr1.getClass();
        Method m = c.getMethod("add", Object.class);
        m.invoke(arr1,"字符串");
        for(Object i : arr1){
            System.out.println(i);
        }
    }

    /**
     * 反射还能获取类中所有属性、方法、注解、构造方法、私有属性.....
     */
    @Test
    public void test4() throws Exception {
        /**
         * 获取属性,这样只能获取public 属性
         */
        Class c = Person.class;
        Field[] f = c.getFields();
        for(Field i : f){
            System.out.println(i.getName());
        }
        /**
         * 获取本类所有私有的属性
         */
        Field[] t = c.getDeclaredFields();
        for(Field i:t){
            System.out.println(i.getName());
        }

        /**
         *获取类中的所有方法并且使用
         */
        Person t1 = (Person) c.newInstance();
        Method[] m  =c.getMethods();
        for(Method i : m){
            if(i.getName() .equals("setEmail") ){
                i.invoke(t1,"1160827860@qq.com");
            }else if(i.getName().equals("setName")){
                i.invoke(t1,"lzy");
            }else if(i.getName().equals("setAge")){
                i.invoke(t1,21);
            }
        }
        Method p = c.getMethod("print");
        p.invoke(t1);
        /**
         * 获取构造方法,并且使用
         */
        Constructor construct = c.getConstructor(String.class,int.class,String.class);
        t1 = (Person)construct.newInstance("sz",25,"a1160827860@163.com");
        p.invoke(t1);
    }
}
