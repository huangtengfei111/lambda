package com.example.demo.htf;

import com.example.demo.htf.entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: stream sort
 * @Author: huangtf
 * @CreateDate: 2020/11/22 2:25
 * <p>
 * sorted() 自然排序(Comparable)
 * sorted(Comparator com) 定制排序(Comparator)
 */
public class StreamDemo03 {

    List<Student> list = Arrays.asList(
            new Student("zs", 12),
            new Student("ls", 20),
            new Student("ww", 32),
            new Student("ww", 31),
            new Student("ww", 32),
            new Student("zl", 40)
    );

    List<String> list1 = Arrays.asList("aa", "cc", "bb");

    @Test
    public void test() {
        list1.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("--------------------");

        list.stream()
                .sorted((x, y) ->
                {
                    if(x.getName() == y.getName()){
                        return x.getAge().compareTo(y.getAge());
                    }else return x.getName().compareTo(x.getName());
                })
                .forEach(System.out::println);
    }
}
