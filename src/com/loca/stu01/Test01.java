package com.loca.stu01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangHeng
 * @date  2020-05-25 19:52
 */
public class Test01 {
    @Test
    public void demo1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程a执行");
            }
        }).start();
    }
    @Test
    public void demo2() {
        new Thread(()->{
            System.out.println("Lambda线程a执行");
        }).start();
    }

    @Test
    public void demo03() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("小王", 23, "男"));
        personList.add(new Person("小名", 24, "女"));
        personList.add(new Person("小黑", 25, "男"));
        personList.add(new Person("小红", 19, "女"));

        /*Collections.sort(personList, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });*/

        //调用的方法他的参数是接口,就可以考虑使用Lambda表达式来代替匿名内部类,但不是所有的匿名内部类都能用Lambda表达式来替换,
        //Lambda表达式相当于接口的抽象方法的重写
        Collections.sort(personList, Comparator.comparingInt(Person::getAge));
        personList.forEach(System.out::println);

        /*for (Person p : personList) {
            System.out.println(p);
        }
        System.out.println("============");*/

    }


}
