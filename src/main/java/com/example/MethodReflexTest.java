package com.example;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 反射获取构造方法
 */
@SuppressWarnings("all")
public class MethodReflexTest {

    /**
     * public Method getMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException
     *      获取反射类或其父类中指定（方法名称 & 型参列表）的成员方法（只能获取 public 修饰的成员方法）
     * @throws Exception
     */
    @Test
    public void test01() throws Exception {
        Class<Person> personClass = Person.class;

        Method eat1 = personClass.getMethod("eat");
        // 输出内容：public void com.example.Person.eat()
        System.out.println(eat1);

        Method eat2 = personClass.getMethod("eat", String.class);
        // 输出内容：public void com.example.Person.eat(java.lang.String)
        System.out.println(eat2);
    }

    /**
     * public Method[] getMethods() throws SecurityException
     *      获取反射类及其父类中的所有 public 修饰的成员方法
     * @throws Exception
     */
    @Test
    public void test02() throws Exception {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getMethods();
        Arrays.stream(methods).forEach(System.out::println);
    }

    /**
     * public Method getDeclaredMethod(String name, Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException
     *      获取反射类或其父类中指定（方法名称 & 型参列表）的成员方法（public、protected、default、private 都可以获取到）
     * @throws Exception
     */
    @Test
    public void test03() throws Exception {
        Class<Person> personClass = Person.class;
        // 获取 private 修饰的方法
        Method sleep = personClass.getDeclaredMethod("sleep");
        System.out.println(sleep);
    }

    /**
     * public Method[] getDeclaredMethods() throws SecurityException
     *      获取所有的成员方法（public、protected、default、private 都可以获取到）
     */
    @Test
    public void test04() {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getDeclaredMethods();
        Arrays.stream(methods).forEach(System.out::println);
    }

        /**
         * public Object invoke(Object obj, Object... args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
         *      执行方法
         * @throws Exception
         */
        @Test
        public void test05() throws Exception {
            Class<Person> personClass = Person.class;
            Method eat = personClass.getMethod("eat");
            eat.invoke(new Person());
        }

    /**
     * public void setAccessible(boolean flag) throws SecurityException
     *       访问或修改 private 的修饰的成员方法，会报 java.lang.NoSuchFieldException，
     *       setAccessible 可以忽略访问权限修饰符的安全检查 -- 暴力反射
     * @throws Exception
     */
    @Test
    public void test06() throws Exception {
        Class<Person> personClass = Person.class;
        Method sleep = personClass.getDeclaredMethod("sleep");
        sleep.setAccessible(true);
        sleep.invoke(new Person());
    }

}
