package com.imooc.annotation;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.reflect.Field;

public class test {
    /**
     * @Override 注解代表重写父类方法或者实现接口时用的注解
     * @Deprecated 表示一个方法已经过时
     * @SuppressWarnings 表示在编译过程中忽略警告
     */
      @Test
      @SuppressWarnings(value = "deprecation")
    public void test(){
        Person p = new Person();
        p.print();
      }
      @Test
      public void test1(){
              Filter f1 = new Filter();
              f1.setName("atu");
              Filter f2 = new Filter();
              f2.setMail("1160827860@qq.com");
              String sql1 = query(f1);
              System.out.println(sql1);
              String sql2 = query(f1);
              String sql3 = query(f1);
      }
    private static String query(Filter f){
        StringBuilder builder = new StringBuilder();
        Class c = f.getClass();
        boolean exist = c.isAnnotationPresent(Table.class);
        if(!exist){
            return null;
        }
        Table t = (Table) c.getAnnotation(Table.class);
        String stringName = t.value();
        builder.append("select * from").append(stringName).append("where id =  1");
        Field[] fArray = c.getDeclaredFields();
        for(Field field : fArray){
            boolean fExists = field.isAnnotationPresent(Column.class);
            if(!fExists){
                continue;
            }
            Column column = field.getAnnotation(Column.class);
            String co = column.value();
            String filedName = field.getName();
            String getMethod = "get" + filedName.substring(0,1).toUpperCase() + filedName.substring(1);
        }
        return builder.toString();
    }

}
