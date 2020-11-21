package com.example.demo.htf;

/**
 * @Description: lambda 方法引用和构造器引用
 * @Author: huangtf
 * @CreateDate: 2020/11/21 22:01
 */

import com.example.demo.htf.entity.Student;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.*;

/**
 * 前提：若lambda方法体中的使用的方法已经有实现了，name才可以使用方法引用
 * 一：方法引用的语法
 * 1. 对象：：实例方法名
 * 2. 类：：静态方法名
 * 3. 类：：实例方法名
 * 使用方法引用 注意事项：
 * 1. lambda方法体中的调用的方法的返回值，参数列表与 函数式接口中抽象方法的返回值，参数列表必须完全相同，这样可以简写
 * 2. 若要使用类：：实例方法名，lambda表达式的第一个参数是lambda表达式中方法的调用者，
 * 第二个参数是lambda表达式中方法的中参数
 *
 * 二： 构造器引用
 * ClassName：：new
 *
 * 三： 数组引用
 * Type[]：：new
 *
 */
public class LambdaDemo02 {

    @Test
    // 对象：：实例方法名 System.out是对象 public void println(Object x)      void accept(T t);
    // 使用方法引用，两个方法的返回值，参数列表必须完全相同，这样可以简写
    public void test01() {
        Consumer c = (x) -> System.out.println(x);
        c.accept(3);

        c = System.out::println;
        c.accept(5);

        Student s = new Student();
        s.setName("zs");
        Supplier supplier = () -> s.getName();
        supplier = s::getName;
        System.out.println(supplier.get());
    }

    @Test
    //类：：静态方法名
    public void test02() {
        //有返回值的这种，泛型必须明确写上
        Comparator<Long> c = (x, y) -> Long.compare(x, y);
        System.out.println(c.compare(3L, 5L));

        c = Long::compare;
        System.out.println(c.compare(6L, 5L));
    }

    @Test
    //类：：实例方法名
    public void test03() {
        BiPredicate<String, String> predicate = (x, y) -> x.equals(y);
        predicate.test("zs", "ls");
        System.out.println(predicate);
        predicate = String::equals;
        System.out.println(predicate);
    }

    @Test
    //构造器引用
    public void test04() {
        Supplier<Student> supplier = () -> new Student();

        supplier = Student::new;

        //泛型中的类型顺序 入参，返回的参数
       // BiFunction<String, String, Integer> bi = Student::new;
    }

    @Test
    //数组引用
    public void test05() {
        Function<Integer, String[]> function = (x) -> new String[x];
        function = String[]::new;
        String[] strings = function.apply(8);
        System.out.println(strings.length);
    }
}
