package com.darksouls.datastructures.collection;

import java.util.Iterator;

/**
 *作用：和jdk中Collection接口一样，这个接口是一种单列集合，统一定义了
 * 单列集合的接口，同时它是所有集合类的父类，提供了删除、插入、判断
 * 一个元素是否为成员、遍历等操作。
 *
 * 第二个就是一切异常抛出不会和jdk中的那么详细，毕竟重点还是数据结构
 * 方面
 *
 * 第三就是其中java8中的一些方法例如stream这类的新特性没有实现
 *由于我才疏学浅，关于java8中的Iterable接口中的for each语法糖实现我还
 * 是不太懂，所以我继承了jdk中的Iterable。
 * @author Darksouls
 * @see java.util.Collection
 * @param <T> 此集合中元素的类型
 */
public interface MyCollection<T>  extends Iterable<T>{
    /**
     *返回集合中的元素个数、如果元素个数大于Integer.MAX_VALUE，就返
     * 回Integer.MAX_VALUE
     * @return 集合中的元素个数
     */
    int size();

    /**
     * 检查是集合是否为空
     * @return 如果为空返回true
     */
    boolean isEmpty();

    /**
     *包含这个元素就返回true
     * 注：在反射中的学习中学过，泛型只是为了提醒输入错误、而集合类的
     * 底层无论传入什么都是由Object的类型存储的。
     * @param o 该元素在此集合中是否存在
     * @return  o 元素在集合中存在就返回true
     * @throws ClassCastException 如果指定元素的类型与此集合不兼容
     * @throws NullPointerException  如果指定的元素为空，并且此集合不允许
     *                                                    空元素
     */
    boolean contains(Object o);

    /**
     * 向集合中添加元素 e
     * @param e 被添加的元素e
     * @return 添加成功就返回true
     * @throws  UnsupportedOperationException - 如果此 集合不支持add操作
     * @throws ClassCastException - 如果指定元素的类阻止将其添加到此集合
     * @throws NullPointerException - 如果指定的元素为空，并且该集合不允许
     *                                                     空元素
     * @throws IllegalArgumentException - 如果元素的某些属性阻止其添加到此
     *                                                            集合
     * @throws IllegalStateException - 如果由于插入限制，此时无法添加该元素
     */
    boolean add(T e);

    /**
     * 删除集合中的o元素如果有的话
     * @param o 待删除的元素
     * @return 删除成功返回true
     * @throws ClassCastException - 如果指定元素的类型与此集合不兼容
     * @throws NullPointerException - 如果指定的元素为空，并且此集合不允许空元素
     * @throws UnsupportedOperationException - 如果此 集合不支持remove操作
     */
    boolean remove(Object o);

    /**
     *将集合转为数组
     * 使用方法为：
     *    MyLinkedList<String> a = new MyLinkedList();
     *    a.add("a");
     *    String[] tp = a.toArray(new String[0]);
     *
     * @param a  要存储此集合的元素的数组，如果它足够大; 否则，为此目的
     *                    分配相同运行时类型的新数组。
     * @param <T> 包含集合的数组的运行时类型
     * @return 包含此集合中的所有元素
     */
    <T> T[] toArray(T[] a);

    /**
     * 将集合转为Object数组
     * @return 包含此集合中的所有元素
     */
    Object[] toArray();

    /**
     * 返回集合中元素的迭代器
     * @return 返回集合中元素的迭代器
     */
    @Override
    Iterator<T> iterator();

    /**
     *如果此集合包含指定 集合中的所有元素，则返回true。
     * @param c 要在此集合中检查的集合
     * @return true如果此集合包含指定集合中的所有元素
     * @throws ClassCastException - 如果指定集合中的一个或多个元素的类型
     *                                                    与此集合不兼容
     * @throws NullPointerException - 如果指定的集合包含一个或多个空元素，
     *                                                     并且此集合不允许空元素（ optional ），
     *                                                     或者指定的集合为空。
     */
    boolean containsAll(MyCollection<?> c);

    /**
     * 使用通配符定义了上界，只要是<？ extendsT>类型的子类就可以被传入
     * @param c 包含要添加到此集合的元素的集合
     * @return 如果此集合被成功添加就返回true
     * @throws UnsupportedOperationException 如果此 集合不支持addAll操作
     * @throws ClassCastException - 如果指定集合的元素的类阻止将其添加到
     *                                                    此集合
     * @throws NullPointerException - 如果指定的集合包含一个空元素，并且此
     *                                                     集合不允许空元素，或者如果指定的集合
     *                                                     为空
     * @throws IllegalArgumentException - 如果指定集合的元素的某些属性阻止
     *                                                            其添加到此集合
     * @throws IllegalStateException - 如果不是所有的元素可以在此时由于插入
     *                                                     限制添加
     */
    boolean addAll(MyCollection<? extends T> c);

    /**
     *删除指定集合中包含的所有此集合的元素（可选操作）。 此调用返回后，
     * 此集合将不包含与指定集合相同的元素。
     * @param c 包含要从此集合中删除的元素的集合
     * @return  如果此集合由于调用而更改返回true
     */
    boolean removeAll(MyCollection<?> c);

    /**
     * 清除集合中的所有元素
     */
    void  clear();

    /**
     * 检查两个集合是否相等
     * @param o 传入的集合
     * @return 里面的元素相等的时候返回true
     */
    @Override
    boolean equals(Object o);





}
