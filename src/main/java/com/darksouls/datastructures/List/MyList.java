package com.darksouls.datastructures.List;

public interface MyList<T> extends Comparable<T>{

    int add(T object);

    int add(int i,T object);

    int addFrist(T object);

    int delLast();

    int size();

    T delect();


}
