package com.example.demo.htf;

import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Description: localDate
 * @Author: huangtf
 * @CreateDate: 2020/11/24 0:12
 */
public class LocalDateDemo {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    DateTimeFormatter dfm = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Test
    public void  test(){
        LocalDateTime date = LocalDateTime.parse("2020-11-24 00:31:20", formatter);
        //LocalDateTimeSerializer date = new LocalDateTimeSerializer(formatter);
        System.out.println(date);
    }
}
