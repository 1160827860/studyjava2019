package com.proxy.diyproxy;
import com.imooc.mode.proxy.diyproxy.InvocationHandler;
import com.imooc.mode.proxy.Moveable;

import java.lang.reflect.Method;

class $Proxy0 implements com.imooc.mode.proxy.Moveable{
private InvocationHandler h;
  public $Proxy0 (InvocationHandler h){   
    super();   
   this.h = h;   
  }
 @Override
public void move() {
try{
Method md =com.imooc.mode.proxy.Moveable.class.getMethod("move");
h.invoke(this,md);
}catch(Exception e){e.printStackTrace();}
};
 }