package com.javase.study.Lambda;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * 练习：求数组元素最大值
 * 使用Supplier接口作为方法参数类型，通过Lambda表达式求出int数组中的最大值。
 * Supplier<T>接口也被称为生产型接口，如果我们指定了接口的泛型是什么类型，那么接口中的get方法就会生产什么类型的数据供我们使用。
 */
public class Test_Supplier {
    //定义一个方法,用于获取int类型数组中元素的最大值,方法的参数传递Supplier接口,泛型使用Integer
    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }

    public static void main(String[] args) {
        //定义一个int类型的数组,并赋值
        int[] arr = {0, -82, 65, 1111, -2024, 100};
        //调用getMax方法,方法的参数Supplier是一个函数式接口,所以可以传递Lambda表达式
        int maxValue = getMax( () -> {
            //获取数组的最大值,并返回
            //定义一个变量,把数组中的第一个元素赋值给该变量,记录数组中元素的最大值
            int max = arr[0];
            //遍历数组,获取数组中的其他元素
            for (int i : arr) {
                //使用其他的元素和最大值比较
                if (i > max) {
                    //如果i大于max,则替换max作为最大值
                    max = i;
                }
            }
            //返回最大值
            return max;
        } );
        System.out.println( "数组中的最大值为：" + maxValue );
        //stream流查找最大值
        Arrays.stream( arr ).max().stream().forEach( System.out::println );
    }
}
