package com.example.demo.htf;

import com.example.demo.htf.entity.Student;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Description: Stream的 查找与匹配
 * @Author: huangtf
 * @CreateDate: 2020/11/22 17:35
 */
public class StreamDemo04 {

    List<Student> list = Arrays.asList(
            new Student("zs", 12),
            new Student("ls", 20),
            new Student("ww", 32),
            new Student("ww", 31),
            new Student("ww", 32),
            new Student("zl", 40)
    );

    @Test
    public void test() {
        Optional<Student> optional = list.stream()
                .sorted((s1, s2) -> -Integer.compare(s1.getAge(), s2.getAge()))
                .findFirst();

        Student student = optional.get();
        System.out.println(student);
    }

    @Test
    //找到学生中年龄最大的
    public void test01() {
        Optional<Integer> max = list.stream()
                .map((s) -> s.getAge())
                .max(Integer::compareTo);
        System.out.println(max.get());
    }

    @Test
    //归约 可以将流中的值反复结合起来，得到一个值
    public void test02() {
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer sum = list1.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(sum);

        Optional<Integer> reduce = list.stream()
                .map((s) -> s.getAge())
                .reduce((a, b) -> Integer.sum(a, b));

        System.out.println(reduce.get());
    }
}
