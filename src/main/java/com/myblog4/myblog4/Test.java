package com.myblog4.myblog4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
//        Predicate<Integer>val= y->y%2==0;
//        boolean result = val.test(10);
//        System.out.println(result);

//       Predicate<String>val= str->str.equals("aman");
//        boolean result = val.test("kaya");
//        System.out.println(result);

//        List<Integer> numbers = Arrays.asList(11, 25, 36, 41, 98, 35, 26);
//        List<Integer> result = numbers.stream().filter(t -> t % 2 == 0).collect(Collectors.toList());
//        System.out.println(result);

//        List<Integer> numbers = Arrays.asList(10, 35, 21, 24, 25, 34);
//        List<Integer> result = numbers.stream().filter(y -> y % 2 != 0).collect(Collectors.toList());
//        System.out.println(result);

        List<String> names = Arrays.asList("kiran", "mike", "stallin", "axay","stallin");
        List<String> data1 = names.stream().filter(str -> str.startsWith("k")).collect(Collectors.toList());
        List<String> data2 = names.stream().filter(str -> str.equals("stallin")).collect(Collectors.toList());
        List<String> data3 = names.stream().filter(str -> str.endsWith("e")).collect(Collectors.toList());
        System.out.println(data1);
        System.out.println(data2);
        System.out.println(data3);
    }
}
