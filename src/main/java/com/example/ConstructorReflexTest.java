package com.example;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.util.Arrays;

/**
 * 反射获取构造方法
 */
@SuppressWarnings("all")
public class ConstructorReflexTest {

    /**
     * public Constructor<T> getConstructor(Class<?>... parameterTypes)
     *      获取（指定型参列表 & public 修饰的）构造方法
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        Class<Person> personClass = Person.class;
        // 获取 public 修饰的无参构造
        Constructor<Person> constructor = personClass.getConstructor();
        System.out.println(constructor);
    }

    /**
     * public Constructor<?>[] getConstructors() throws SecurityException
     *      获取所有 public 修饰的构造方法
     */
    @Test
    public void test02()   {
        Class<Person> personClass = Person.class;
        // 获取所有 public 修饰的构造方法
        Constructor<?>[] constructors = personClass.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);
    }

    /**
     * public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException
     *      获取指定型参列表的构造方法
     * @throws Exception
     */
    @Test
    public void test03() throws Exception {
        Class<Person> personClass = Person.class;
        // 获取 private 修饰的双参构造
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class, String.class);
        System.out.println(constructor);
    }

    /**
     * public Constructor<?>[] getDeclaredConstructors() throws SecurityException
     *      获取所有的构造方法
     */
    @Test
    public void test04() {
        Class<Person> personClass = Person.class;
        // 获取 public 修饰的无参构造
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(System.out::println);
    }

    /**
     * public T newInstance(Object ... initargs)
     *      实例化对象，注意：newInstance 的型参列表必须要 getConstructor 的型参列表相同
     * @throws Exception
     */
    @Test
    public void test05() throws Exception {
        Class<Person> personClass = Person.class;
        // 获取 public 修饰的无参构造
        Constructor<Person> constructor = personClass.getConstructor();
        // newInstance 的型参列表必须要 getConstructor 的型参列表相同
        Person person = constructor.newInstance();
        System.out.println(person);
    }

    /**
     * public void setAccessible(boolean flag) throws SecurityException
     *       访问或修改 private 的修饰的构造方法，会报 java.lang.NoSuchFieldException，
     *       setAccessible 可以忽略访问权限修饰符的安全检查 -- 暴力反射
     * @throws Exception
     */
    @Test
    public void test06() throws Exception {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getDeclaredConstructor(String.class, String.class);
        constructor.setAccessible(true);
        Person person = constructor.newInstance("男", "上海");
        System.out.println(person);
    }

}
