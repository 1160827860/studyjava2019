package com.darksouls.datastructures.abstractcollection;

import com.darksouls.datastructures.collection.MyCollection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * TODO 使用了Collection接口、为什么还要MyAbstractCollection类?
 * 该类提供了Collection接口的骨架实现，以尽量减少实现此接口所需的工作量
 * 明确接口和抽象类的区别，接口只能定义方法，不能写默认方法，也不能定
 * 义变量，AbstractCollection相当于提供了骨架，jdk中在这个抽象类中定义了
 * 大量的默认方法。
 * @param <T>
 */
public  abstract    class MyAbstractCollection<T> implements MyCollection<T> {

    protected MyAbstractCollection(){
    }



    /**
     * 返回集合中的元素个数、如果元素个数大于Integer.MAX_VALUE，就返
     * 回Integer.MAX_VALUE
     * 定义为抽象方法，子类如果不是抽象类，则必须要实现此方法
     * @return 集合中的元素个数
     */
    @Override
    public abstract int size();


    /**
     * 检查是集合是否为空
     * 原理调用size()方法若 size() == 0 自然是ture
     * @return 如果为空返回true
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * 包含这个元素就返回true
     * 注：在反射中的学习中学过，泛型只是为了提醒输入错误、而集合类的
     * 底层无论传入什么都是由Object的类型存储的。
     * null也可以算一种集合中的元素
     * @param o 该元素在此集合中是否存在
     * @return o 元素在集合中存在就返回true
     * @throws ClassCastException   如果指定元素的类型与此集合不兼容
     * @throws NullPointerException 如果指定的元素为空，并且此集合不允许
     *                              空元素
     */
    @Override
    public boolean contains(Object o) {
        Iterator<T> it = iterator();
        if(o == null){
            while (it.hasNext()){
                if(it.next() == null){
                    return true;
                }
            }
        }else {
            while (it.hasNext()){
                if(it.next().equals(o)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 向集合中添加元素 e
     *
     * @param e 被添加的元素e
     * @return 添加成功就返回true
     * @throws UnsupportedOperationException - 如果此 集合不支持add操作
     * @throws ClassCastException            - 如果指定元素的类阻止将其添加到此集合
     * @throws NullPointerException          - 如果指定的元素为空，并且该集合不允许
     *                                       空元素
     * @throws IllegalArgumentException      - 如果元素的某些属性阻止其添加到此
     *                                       集合
     * @throws IllegalStateException         - 如果由于插入限制，此时无法添加该元素
     */
    @Override
    public boolean add(T e) {
        return false;
    }

    /**
     * 删除集合中的o元素如果有的话
     *
     * @param o 待删除的元素
     * @return 删除成功返回true
     * @throws ClassCastException            - 如果指定元素的类型与此集合不兼容
     * @throws NullPointerException          - 如果指定的元素为空，并且此集合不允许空元素
     * @throws UnsupportedOperationException - 如果此 集合不支持remove操作
     */
    @Override
    public boolean remove(Object o) {
        return false;
    }

    /**
     * 将集合转为数组
     * 使用方法为：
     * MyLinkedList<String> a = new MyLinkedList();
     * a.add("a");
     * String[] tp = a.toArray(new String[0]);
     *
     * @param a 要存储此集合的元素的数组，如果它足够大; 否则，为此目的
     *          分配相同运行时类型的新数组。
     * @return 包含此集合中的所有元素
     */
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    /**
     *jdk中还要考虑元素少于size()的情况、还有集合中元素大于size()的情况
     * @return
     */
//    @Override
//    public Object[] toArray() {
//        Object[] o = new  Object[size()];
//        Iterator<T> it = iterator();
//        for(int i = 0 ;i < o.length;i ++){
//            while (it.hasNext()){
//                if(! it.hasNext()){
//                    return Arrays.copyOf(o,i);
//                }
//                o[i] = it.next();
//            }
//        }
//        return it.hasNext() ? finishToArray(o,it) : o;
//    }
//
//    /**
//     * 由于集合中元素大于size()，所以调用finishToArray来对集合中剩余的元
//     * 素放入数组之中
//     * @param o size()大小的数组
//     * @param it 集合的迭代器
//     * @return 返回集合中包含所有元素的数组
//     */
//    public static  <T> T[] finishToArray(T[] o,Iterator<?> it){
//
//    }
    /**
     * 返回集合中元素的迭代器
     *
     * @return 返回集合中元素的迭代器
     */
    @Override
    public abstract Iterator<T> iterator();

    /**
     * Performs the given action for each element of the {@code Iterable}
     * until all elements have been processed or the action throws an
     * exception.  Unless otherwise specified by the implementing class,
     * actions are performed in the order of iteration (if an iteration order
     * is specified).  Exceptions thrown by the action are relayed to the
     * caller.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @implSpec <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     * @since 1.8
     */
    @Override
    public void forEach(Consumer<? super T> action) {

    }

    /**
     * Creates a {@link Spliterator} over the elements described by this
     * {@code Iterable}.
     *
     * @return a {@code Spliterator} over the elements described by this
     * {@code Iterable}.
     * @implSpec The default implementation creates an
     * <em><a href="Spliterator.html#binding">early-binding</a></em>
     * spliterator from the iterable's {@code Iterator}.  The spliterator
     * inherits the <em>fail-fast</em> properties of the iterable's iterator.
     * @implNote The default implementation should usually be overridden.  The
     * spliterator returned by the default implementation has poor splitting
     * capabilities, is unsized, and does not report any spliterator
     * characteristics. Implementing classes can nearly always provide a
     * better implementation.
     * @since 1.8
     */
    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    /**
     * 如果此集合包含指定 集合中的所有元素，则返回true。
     *
     * @param c 要在此集合中检查的集合
     * @return true如果此集合包含指定集合中的所有元素
     * @throws ClassCastException   - 如果指定集合中的一个或多个元素的类型
     *                              与此集合不兼容
     * @throws NullPointerException - 如果指定的集合包含一个或多个空元素，
     *                              并且此集合不允许空元素（ optional ），
     *                              或者指定的集合为空。
     */
    @Override
    public boolean containsAll(MyCollection<?> c) {
        return false;
    }

    /**
     * 使用通配符定义了上界，只要是<？ extendsT>类型的子类就可以被传入
     *
     * @param c 包含要添加到此集合的元素的集合
     * @return 如果此集合被成功添加就返回true
     * @throws UnsupportedOperationException 如果此 集合不支持addAll操作
     * @throws ClassCastException            - 如果指定集合的元素的类阻止将其添加到
     *                                       此集合
     * @throws NullPointerException          - 如果指定的集合包含一个空元素，并且此
     *                                       集合不允许空元素，或者如果指定的集合
     *                                       为空
     * @throws IllegalArgumentException      - 如果指定集合的元素的某些属性阻止
     *                                       其添加到此集合
     * @throws IllegalStateException         - 如果不是所有的元素可以在此时由于插入
     *                                       限制添加
     */
    @Override
    public boolean addAll(MyCollection<? extends T> c) {
        return false;
    }

    /**
     * 删除指定集合中包含的所有此集合的元素（可选操作）。 此调用返回后，
     * 此集合将不包含与指定集合相同的元素。
     *
     * @param c 包含要从此集合中删除的元素的集合
     * @return 如果此集合由于调用而更改返回true
     */
    @Override
    public boolean removeAll(MyCollection<?> c) {
        return false;
    }

    /**
     * 清除集合中的所有元素
     */
    @Override
    public void clear() {

    }
}
