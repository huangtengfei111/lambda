package com.example.demo.htf;

import com.example.demo.htf.entity.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description: Stream
 * @Author: huangtf
 * @CreateDate: 2020/11/22 0:40
 *
 *
 */
public class StreamDemo01 {

    List<Student> list = Arrays.asList(
            new Student("zs", 12),
            new Student("ls", 20),
            new Student("ww", 32),
            new Student("ww", 32),
            new Student("ww", 32),
            new Student("zl", 40)
            );


    //创建stream
    @Test
    public void test01(){
        //1. 可以通过Collection系列提供的stream()(串行流)或parallelStream()（并行流）
        List<String> list = new ArrayList();
        Stream<String> stream1 = list.stream();

        //通过Arrays中的静态方法stream()获取数组流
        Student[] students = new Student[10];
        Stream<Student> stream2 = Arrays.stream(students);

        //通过Stream类中的of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");

        //创建无限流
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
    }

    @Test
    //当limit满足后，就不再继续执行遍历
    public void test02(){
        list.stream()
                .filter((x) -> {
                    System.out.println("短路");
                    return x.getAge() > 25;
                })
                .limit(1)
                .forEach(System.out::println);
    }

    @Test
    //skip 跳过满足条件的n个，返回剩下满足条件的
    public void test03(){
        list.stream()
                .filter((x) -> {
                    System.out.println("短路");
                    return x.getAge() > 15;
                })
                .skip(1)
                .forEach(System.out::println);
    }

    @Test
    //distinct  通过流元素中的hashcode() 和equals()去除重复元素
    public void test04(){
        list.stream()
                .filter((x) -> {
                    return x.getAge() > 15;
                })
                .distinct()
                .forEach(System.out::println);
    }
}
