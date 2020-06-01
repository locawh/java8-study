package com.loca.stu01;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangHeng
 * @date  2020-05-27 11:08
 */
public class GroupByTest {

    @Test
    public void test01() {
        List<User> users = testParams();
        users.forEach(System.out::println);

        System.out.println("==============groupingBy");
        Map<String, List<User>> collect = testParams().stream().collect(Collectors.groupingBy(User::getEdu));
        Iterator<Map.Entry<String, List<User>>> iterator = collect.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, List<User>> next = iterator.next();
            List<User> value = next.getValue();
            value.forEach(System.out::println);
        }

        System.out.println("==============groupingBy===mapping==映射指定字段");
        Map<String, List<Integer>> collect1 = users.stream().collect(Collectors.groupingBy(User::getEdu,
                //第二个参数对Map的value进行处理（映射）
                Collectors.mapping(User::getSchoolId, Collectors.toList())));
        collect1.forEach((key, value) -> System.out.println(key + "==" + value));
        for (List<Integer> value : collect1.values()) {
            value.forEach(System.out::println);
        }

        System.out.println("==============groupingBy===summingDouble==对结果的指定字段进行求和");
        Map<String, Double> doubleMap = users.stream().collect(Collectors.groupingBy(User::getEdu, Collectors.summingDouble(User::getPrice)));
        System.out.println(doubleMap);

        System.out.println("==============groupingBy===summingDouble==统计分组后的结果");
        Map<String, Long> collect2 = users.stream().collect(Collectors.groupingBy(User::getEdu, Collectors.counting()));
        System.out.println(collect2);

        System.out.println("==============groupingBy===指定map的生成方式==统计分组后的结果");
        TreeMap<String, Double> collect3 = users.stream().collect(Collectors.groupingBy(User::getEdu, TreeMap::new, Collectors.summingDouble(User::getPrice)));
        System.out.println(collect3);
    }

    public List<User> testParams() {
        List<User> users = new ArrayList<>();
        User u1 = new User();
        u1.setId(1001);
        u1.setSchoolId(100);
        u1.setUserName("小1");
        u1.setEdu("001");
        u1.setPrice(0.01);

        User u2 = new User();
        u2.setId(1002);
        u2.setSchoolId(100);
        u2.setUserName("小2");
        u2.setEdu("002");
        u2.setPrice(0.20);

        User u3 = new User();
        u3.setId(2010);
        u3.setSchoolId(200);
        u3.setUserName("小3");
        u3.setEdu("001");
        u3.setPrice(3.00);

        User u4 = new User();
        u4.setId(3001);
        u4.setSchoolId(300);
        u4.setEdu("001");
        u4.setPrice(40.0);

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);
        return users;
    }
}
