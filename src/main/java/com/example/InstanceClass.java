package com.example;

import org.junit.Test;

/**
 * 创建 Class 对象的三种方式
 */
@SuppressWarnings("all")
public class InstanceClass {

    /**
     * 对应【阶段一：Source 源代码阶段】
     * Class.forName("全限定类名")：将字节码文件加载进内存，返回 Class 对象
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        Class<?> personClass = Class.forName("com.example.Person");
    }

    /**
     * 对应【阶段二：Class 类对象阶段】
     * 类名.class：通过类名的属性 class 获取
     */
    @Test
    public void test02() {
        Class<Person> personClass = Person.class;
    }

    /**
     * 对应【阶段三：RunTime 运行时阶段】
     * 实例.getClass()：getClass() 方法是定义在 Objec 类中的方法
     */
    @Test
    public void test03() {
        Class<? extends Person> personClass = new Person().getClass();
    }

    /**
     * 同一个字节码文件 （*.class）在一次程序运行过程中，只会被加载一次！
     *
     * 无论通过哪一种方式获取的 Class 对象都是同一个！
     */
    @Test
    public void test04() throws Exception {
        Class<?> cls1 = Class.forName("com.example.Person");
        Class<Person> cls2 = Person.class;
        Class<? extends Person> cls3 = new Person().getClass();
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
    }

}
