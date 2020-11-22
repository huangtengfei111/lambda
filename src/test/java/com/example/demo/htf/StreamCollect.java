package com.example.demo.htf;

import com.example.demo.htf.entity.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description: 收集，将流中的元素收集到指定的集合
 * @Author: huangtf
 * @CreateDate: 2020/11/22 18:19
 */
public class StreamCollect {

    List<Student> list = Arrays.asList(
            new Student("zs", 12),
            new Student("ls", 20),
            new Student("ww", 32),
            new Student("ww", 31),
            new Student("ww", 32),
            new Student("zl", 40)
    );

    @Test
    public void test(){
        //将所有的学生名字收集到list
        List<String> list1 = list.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        list1.forEach(System.out::println);

        System.out.println("--------------------");

        //名字去重
        Set<String> set = list.stream()
                .map(Student::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println("--------------------");

        //名字放入arrayList
        ArrayList<String> arrayList = list.stream()
                .map(Student::getName)
                .collect(Collectors.toCollection(ArrayList::new));
        arrayList.forEach(System.out::println);
    }
}
