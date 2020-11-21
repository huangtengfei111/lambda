package com.example.demo.htf;

import com.example.demo.htf.service.MyFunc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.CompareTo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: huangtf
 * @CreateDate: 2020/11/19 22:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class LambdaDemo01 {

    //无参无返回值的lambda表达式
    @Test
    public void test01(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        r.run();

        System.out.println("--------------------");
        Runnable r1 = () -> System.out.println("hello world");
        r1.run();
    }

    @Test
    public void test02(){
        Comparator<Integer> c = (x, y) -> {
            System.out.println("hello world");
            return Integer.compare(x,y);
        };
        System.out.println(c.compare(3,2));

    }

    //应用 对一个数进行运算
    @Test
    public void test03(){
        Integer num = operation(100, (x) -> x + 200);
        System.out.println(num);

        Integer num2 = operation(20, (x) -> x * 3);
        System.out.println(num2);
    }

    public Integer operation(Integer x, MyFunc myFunc){
        return myFunc.getValue(x);
    }
}
