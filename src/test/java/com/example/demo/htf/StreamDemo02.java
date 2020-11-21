package com.example.demo.htf;

import com.example.demo.htf.entity.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description: java类作用描述
 * @Author: huangtf
 * @CreateDate: 2020/11/22 1:33
 *
 *
 * map 接收lambda，将元素转换为其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新元素。
 * flatmap 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成流。
 */
public class StreamDemo02 {

    List<Student> list = Arrays.asList(
            new Student("zs", 12),
            new Student("ls", 20),
            new Student("ww", 32),
            new Student("ww", 32),
            new Student("ww", 32),
            new Student("zl", 40)
    );

    List<String> list1 = Arrays.asList("aa", "bb", "cc");

    @Test
    public void test01() {
        list1.stream()
                .map((x) -> x.toUpperCase())
                .forEach(System.out::println);


        list.stream()
                .map((x) -> x.getName())
                .forEach(System.out::println);
    }


    //遍历list1中的每一个字符
    @Test
    public void test02() {
        StreamDemo02 streamDemo02 = new StreamDemo02();
      /*  Stream<Stream<Character>> streamStream = list1.stream()
                .map((x) -> streamDemo02.toCharacter(x));

        streamStream.forEach((sm) -> {
            sm.forEach(System.out::println);
        });*/

        //flatmap  接收一个函数作为参数，      将流中的每个值都换成另一个流，然后把所有流连接成流。
        // 上面注释的可以简写为如下 实际操作是
        // 将流中的每个值转换为流{a, a}, {b, b},{c, c}    将所有流连接成流    {a, a, b, b, c, c}
        list1.stream()
                .flatMap((x) -> streamDemo02.toCharacter(x))
                .forEach(System.out::println);

        //类似效果
        List list2 = new ArrayList<>();
        list2.add(111);
        list2.add(list1);
        System.out.println(list2); //[111, [aa, bb, cc]]
        List list3 = new ArrayList<>();
        list3.add(111);
        list3.addAll(list1);
        System.out.println(list3); //[111, aa, bb, cc] flatmap 相当于将add的效果变为addAll的效果

    }



    //将字符串中的每个字符放入到流中
    public Stream<Character> toCharacter(String s) {
        List<Character> list = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }
}
