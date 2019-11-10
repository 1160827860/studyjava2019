package com.darksouls.datastructures.list;

import com.darksouls.datastructures.collection.MyCollection;

import java.util.Collection;

public interface MyList<T> extends Collection<T> {
    @Override
    int size();

    @Override
    boolean isEmpty();

    @Override
    boolean contains(Object o);

    @Override
    boolean add(T e);

    @Override    boolean remove(Object o);


     boolean containsAll(MyCollection<?> c);


    boolean addAll(MyCollection<? extends T> c);

    boolean removeAll(MyCollection<?> c);
    @Override
    void  clear();

    @Override
    boolean equals(Object o);



}
