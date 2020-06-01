package com.loca.stu02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangHeng
 * @date  2020-05-28 17:23
 */
public class StudTest {
    public static void main(String[] args) {
        // 初始化
        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };

        /*List<Student> whuStudents = students.stream()
                .filter(student -> "武汉大学".equals(student.getSchool()))
                .collect(Collectors.toList());
        whuStudents.forEach(System.out::println);*/

        /*List<Student> collect = students.stream().filter(e -> e.getAge() % 2 == 0)
                .distinct().
                        collect(Collectors.toList());
        collect.forEach(System.out::println);*/

        List<Student> list = students.stream().filter(e -> e.getSchool().equals("武汉大学"))
                .sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
        list.forEach(System.out::println);

    }
}
