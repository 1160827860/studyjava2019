package com.proxy.staticproxy;

import com.imooc.mode.proxy.Car;
import com.imooc.mode.proxy.Moveable;

import java.util.Date;

/**
 * 使用聚合来实现静态代理
 */
public class Car2 implements Moveable {
    private Car car;
    public Car2(Car car) {
        this.car = car;
    }
    public void move() {
        System.out.println("汽车启动了" + new Date());
        car.move();
        System.out.println("汽车结束启动了" + new Date());
    }


}
