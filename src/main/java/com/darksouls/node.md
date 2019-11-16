# datastructures下的集合类为jdk底层的学习，代码大多数和jdk底层的集合类和框架是一样的。
#easydatasturcut是的集合类为自己实现的集合类不追究上层接口如何实现，光实现集合类

java抽象类和抽象方法
https://blog.csdn.net/tsuliuchao/article/details/5423026:

抽象类和接口的区别
1、抽象类使用abstract修饰；
2、抽象类不能实例化，即不能使用new关键字来实例化对象；
3、含有抽象方法（使用abstract关键字修饰的方法）的类是抽象类，必须使用abstract关键字修饰；
4、抽象类可以含有抽象方法，也可以不包含抽象方法，抽象类中可以有具体的方法；
5、如果一个子类实现了父类（抽象类）的所有抽象方法，那么该子类可以不必是抽象类，否则就是抽象类；
6、抽象类中的抽象方法只有方法体，没有具体实现；
接口：
1、接口使用interface修饰；
2、接口不能被实例化；
3、一个类只能继承一个类，但是可以实现多个接口；
4、接口中方法均为抽象方法；
5、接口中不能包含实例域或静态方法（静态方法必须实现，接口中方法是抽象方法，不能实现）
https://blog.csdn.net/u010003835/article/details/76850242
1.8的新特性
https://blog.csdn.net/u010003835/article/details/76850242
默认方法是在接口中的方法签名前加上了 default 关键字的实现方法。
在 java 8 之前，接口与其实现类之间的 耦合度 太高了（tightly coupled），
当需要为一个接口添加方法时，所有的实现类都必须随之修改。默认方法解
决了这个问题，它可以为接口添加新的方法，而不会破坏已有的接口的实现。
这在 lambda 表达式作为 java 8 语言的重要特性而出现之际，为升级旧接口
且保持向后兼容（backward compatibility）提供了途径。
**例子：这个特性目前被用在List接口中，例如LinkedList对象要调用sort
方法**
**其实调用的是List接口中的sort方法**
**例子2：这个 forEach 方法是 jdk 1.8 新增的接口默认方法，正是因为有了
默认方法的引入，才不会因为 Iterable 接口中添加了 forEach 方法就需要修
改所有 Iterable 接口的实现类。**

# 解决冲突发生
默认方法的多继承
Java 使用的是单继承、多实现的机制，为的是避免多继承带来的调用歧义的问题。当接口的子类同时拥有具有相同签名的方法时，就需要考虑一种解决冲突的方案。
```java
interface InterfaceA {
    default void foo() {
        System.out.println("InterfaceA foo");
    }
}
 
interface InterfaceB {
    default void bar() {
        System.out.println("InterfaceB bar");
    }
}
 
interface InterfaceC {
    default void foo() {
        System.out.println("InterfaceC foo");
    }
    
    default void bar() {
        System.out.println("InterfaceC bar");
    }
}
 
class ClassA implements InterfaceA, InterfaceB {
}
 
// 错误
//class ClassB implements InterfaceB, InterfaceC {
//}
 
class ClassB implements InterfaceB, InterfaceC {
    @Override
    public void bar() {
        InterfaceB.super.bar(); // 调用 InterfaceB 的 bar 方法
        InterfaceC.super.bar(); // 调用 InterfaceC 的 bar 方法
        System.out.println("ClassB bar"); // 做其他的事
    }
}
```
在 ClassA 类中，它实现的 InterfaceA 接口和 InterfaceB 接口中的方法不存在歧义，可以直接多实现。

在 ClassB 类中，它实现的 InterfaceB 接口和 InterfaceC 接口中都存在相同签名的 foo 方法，需要手动解决冲突。覆写存在歧义的方法，并可以使用 InterfaceName.super.methodName(); 的方式手动调用需要的接口默认方法。

```java
class ClassC {
    public void foo() {
        System.out.println("ClassC foo");
    }
}
 
class ClassD extends ClassC {
    @Override
    public void foo() {
        System.out.println("ClassD foo");
    }
}
 
public class Test {
    public static void main(String[] args) {
        ClassC classC = new ClassD();
        classC.foo(); // 打印：“ClassD foo”
    }
}
```
这里的 classC.foo(); 同样调用的是 ClassD 类中的 foo 方法，打印结果为“ClassD foo”，因为 ClassC 类中的 foo 方法在 ClassD 类中被覆写了。
而覆写意味着对父类方法的屏蔽，这也是 Override 的设计意图之一。因此在实现了 InterfaceB 接口的类中无法访问已被覆写的 InterfaceA 接口中的 foo 方法。
```java
interface InterfaceA {
    default void foo() {
        System.out.println("InterfaceA foo");
    }
}
 
interface InterfaceB extends InterfaceA {
    @Override
    default void foo() {
        System.out.println("InterfaceB foo");
    }
}
 
interface InterfaceC extends InterfaceA {
    @Override
    default void foo() {
        InterfaceA.super.foo();
    }
}
 
class ClassA implements InterfaceB, InterfaceC {
    @Override
    public void foo() {
        InterfaceB.super.foo();
        InterfaceC.super.foo();
    }
}
```
注意！ 虽然 InterfaceC 接口的 foo 方法只是调用了一下父接口的默认实现方法，但是这个覆写 不能省略，否则 InterfaceC 接口中继承自 InterfaceA 接口的隐式的 foo 方法同样会被认为是被 InterfaceB 接口覆写了而被屏蔽，会导致调用 InterfaceC.super.foo() 时出错。

通过这个例子，应该注意到在使用一个默认方法前，一定要考虑它是否真的需要。因为 默认方法会带给程序歧义，并且在复杂的继承体系中容易产生编译错误。滥用默认方法可能给代码带来意想不到、莫名其妙的错误
#接口与抽象类
当接口继承行为发生冲突时的另一个规则是，类的方法声明优先于接口默认方法，无论该方法是具体的还是抽象的。
```java
interface InterfaceA {
    default void foo() {
        System.out.println("InterfaceA foo");
    }
 
    default void bar() {
        System.out.println("InterfaceA bar");
    }
}
 
abstract class AbstractClassA {
    public abstract void foo();
 
    public void bar() {
        System.out.println("AbstractClassA bar");
    }
}
 
class ClassA extends AbstractClassA implements InterfaceA {
    @Override
    public void foo() {
        InterfaceA.super.foo();
    }
}
 
public class Test {
    public static void main(String[] args) {
        ClassA classA = new ClassA();
        classA.foo(); // 打印：“InterfaceA foo”
        classA.bar(); // 打印：“AbstractClassA bar”
    }
}
```
ClassA 类中并不需要手动覆写 bar 方法，因为优先考虑到 ClassA 类继承了的 AbstractClassA抽象类中存在对 bar 方法的实现，同样的因为 AbstractClassA 抽象类中的 foo 方法是抽象的，所以在 ClassA 类中必须实现 foo 方法。
接口可以被类多实现（被其他接口多继承），抽象类只能被单继承。

接口中没有 this 指针，没有构造函数，不能拥有实例字段（实例变量）或实例方法，无法保存 状态（state），抽象方法中可以。

抽象类不能在 java 8 的 lambda 表达式中使用。

从设计理念上，接口反映的是 “like-a” 关系，抽象类反映的是 “is-a” 关系
default 关键字只能在接口中使用（以及用在 switch 语句的 default 分支），不能用在抽象类中。

接口默认方法不能覆写 Object 类的 equals、hashCode 和 toString 方法。

接口中的静态方法必须是 public 的，public 修饰符可以省略，static 修饰符不能省略。

即使使用了 java 8 的环境，一些 IDE 仍然可能在一些代码的实时编译提示时出现异常的提示（例如无法发现 java 8 的语法错误），因此不要过度依赖 IDE。

# Java中的关键字 transient
https://www.cnblogs.com/chenpi/p/6185773.html
 在讨论transient之前，有必要先搞清楚Java中序列化的含义；
 
 Java中对象的序列化指的是将对象转换成以字节序列的形式来表示，这些字节序列包含了对象的数据和信息，一个序列化后的对象可以被写到数据库或文件中，也可用于网络传输，一般当我们使用缓存cache（内存空间不够有可能会本地存储到硬盘）或远程调用rpc（网络传输）的时候，经常需要让我们的实体类实现Serializable接口，目的就是为了让其可序列化。
 
 当然，序列化后的最终目的是为了反序列化，恢复成原先的Java对象，要不然序列化后干嘛呢，所以序列化后的字节序列都是可以恢复成Java对象的，这个过程就是反序列化。
 
 