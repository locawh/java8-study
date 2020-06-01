package com.loca.stu01;

/**
 * @author wangHeng
 * @date  2020-05-25 20:04
 */
public class Test03 {
    public static void main(String[] args) {
        testSwimming(new Test02() {
            @Override
            public void Swimming() {
                System.out.println("匿名实现抽象接口");
            }
        });
        //当方法的参数是接口时可以考虑使用Lambda表达式的形式
        //Lambda表达式其实就是对接口中的抽象方法的重写
        testSwimming(()-> System.out.println("sdfsdf"));

        testSmoking(new Test04() {
            @Override
            public int Smoking(String name) {
                System.out.println("我抽了一包" + name);
                return 24;
            }
        });

        testSmoking((String name)->{
            System.out.println("我抽了一包=======" + name);
            return 23;
        });



    }

    public static void testSwimming(Test02 test02) {
        test02.Swimming();
    }

    public static void testSmoking(Test04 test04) {
        int i = test04.Smoking("中华");
        System.out.println(i);
    }


}
