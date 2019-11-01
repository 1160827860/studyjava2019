package com.imooc.mode.proxy.diyproxy;
import com.imooc.mode.proxy.Moveable;
import java.util.Date; 
 import java.util.Random;   
 public class $Proxy0 implements Moveable {
 private Moveable m ;   
  public CarTimeProxy (Moveable m){   
    super();   
   this.m = m;   
  }
    public void move() { 
 System.out.println("汽车启动了" + new Date()); 
  m.move();
  long starttime = System.currentTimeMillis();
 try { 
          Thread.sleep(new Random().nextInt(1000));
  } catch (InterruptedException e) {
           e.printStackTrace();
  }
     long endtime =  System.currentTimeMillis();
          System.out.println("汽车运行时间" + (endtime - starttime));
               System.out.println("汽车结束启动了" + new Date());
    }
 }