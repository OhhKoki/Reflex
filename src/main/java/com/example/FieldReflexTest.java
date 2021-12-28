package com.example;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 1. 获取 Field 对象
 *
 *      1）public Field[] getFields() throws SecurityExceptio
 *              获取所有 public 修饰的成员变量
 *
 *      2）public Field getField(String name) throws NoSuchFieldException, SecurityException
 *              获取某个 public 修饰的成员变量
 *
 *      3）public Field getField(String name) throws NoSuchFieldException, SecurityException
 *              获取所有的成员变量
 *
 *      4）public Field getDeclaredField(String name) throws NoSuchFieldException, SecurityException
 *              获取指定的成员变量
 *
 * 2. 通过 Field 操作成员属性
 *
 *      1）public Object get(Object obj) throws IllegalArgumentException, IllegalAccessException
 *              获取成员变量的值
 *
 *      2）public void setAccessible(boolean flag) throws SecurityException
 *              访问或修改 private 的修饰的成员变量，会报 java.lang.NoSuchFieldException，
 *              setAccessible 可以忽略访问权限修饰符的安全检查 -- 暴力反射
 */
@SuppressWarnings("all")
public class FieldReflexTest {

    /**
     * public Field[] getFields() throws SecurityException
     *      获取所有 public 修饰的成员变量
     */
    @Test
    public void test01() {
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getFields();
        Arrays.stream(fields).forEach(System.out::println);
    }

    /**
     * public Field getField(String name) throws NoSuchFieldException, SecurityException
     *      获取某个 public 修饰的成员变量
     * @throws Exception
     */
    @Test
    public void test02() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Field name = personClass.getField("name");
        System.out.println(name);
    }

    /**
     * public Field[] getDeclaredFields() throws SecurityException
     *      获取所有的成员变量
     */
    @Test
    public void test03() {
        Class<Person> personClass = Person.class;
        Field[] declaredFields = personClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(System.out::println);
    }

    /**
     * public Field getDeclaredField(String name) throws NoSuchFieldException, SecurityException
     *      获取指定的成员变量
     * @throws NoSuchFieldException
     */
    public void test04() throws NoSuchFieldException {
        Class<Person> personClass = Person.class;
        Field name = personClass.getDeclaredField("name");
        System.out.println(name);
    }

    /**
     * public Object get(Object obj) throws IllegalArgumentException, IllegalAccessException
     *      获取成员变量的值
     * @throws Exception
     */
    @Test
    public void test05() throws Exception {
        Class<Person> personClass = Person.class;
        Field name = personClass.getField("name");
        Person person = new Person("张三", "18", "男", "上海");
        System.out.println(name.get(person));
    }

    /**
     * public void set(Object obj, Object value) throws IllegalArgumentException, IllegalAccessException
     *      修改成员变量的值
     * @throws Exception
     */
    @Test
    public void test06() throws Exception {
        Class<Person> personClass = Person.class;
        Field name = personClass.getField("name");
        Person person = new Person("张三", "18", "男", "上海");
        name.set(person, "里斯");
        System.out.println(name.get(person));
    }

    /**
     * public void setAccessible(boolean flag) throws SecurityException
     *       访问或修改 private 的修饰的成员变量，会报 java.lang.NoSuchFieldException，
     *       setAccessible 可以忽略访问权限修饰符的安全检查 -- 暴力反射
     * @throws Exception
     */
    @Test
    public void tset07() throws Exception {
        Class<Person> personClass = Person.class;
        Field adress = personClass.getDeclaredField("adress");
        Person person = new Person("张三", "18", "男", "上海");
        // 访问或修改 private 的修饰的成员变量，会报 java.lang.NoSuchFieldException
        adress.setAccessible(true);    // 暴力反射
        adress.set(person, "北京");
        System.out.println(adress.get(person));
    }

}
