package com.myblog4.myblog4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
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

//        List<String> names = Arrays.asList("kiran", "mike", "stallin", "axay","stallin");
//        List<String> data1 = names.stream().filter(str -> str.startsWith("k")).collect(Collectors.toList());
//        List<String> data2 = names.stream().filter(str -> str.equals("stallin")).collect(Collectors.toList());
//        List<String> data3 = names.stream().filter(str -> str.endsWith("e")).collect(Collectors.toList());
//        System.out.println(data1);
//        System.out.println(data2);
//        System.out.println(data3);

        // find the length of given string
//       Function<String,Integer> val= str->str.length();
//        Integer result = val.apply("my name is atit patel");
//        System.out.println(result);

        // add value in given numbers
//       Function<Integer,Integer>number= i->i+10;
//        Integer res = number.apply(25);
//        System.out.println(res);

        // add value of 10 in every number
//        List<Integer> numbers = Arrays.asList(10, 25, 36, 41, 25, 87);
//        List<Integer> result = numbers.stream().map(i -> i + 10).collect(Collectors.toList());
//        System.out.println(result);

        // i wnat all the names in upper case & lower case
//        List<String> names = Arrays.asList("kevin", "rinkesh", "keral", "meet");
//        List<String> result1 = names.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
//        List<String> result2 = names.stream().map(str -> str.toLowerCase()).collect(Collectors.toList());
//        System.out.println(result1);
//        System.out.println(result2);

        // sort all the name in acsending order
//        List<String> names = Arrays.asList("kevin", "rinkesh", "keral", "meet");
//        List<String> res = names.stream().sorted().collect(Collectors.toList());
//        System.out.println(res);

        // sort all the number inasending order
//        List<Integer> numbers = Arrays.asList(10, 26, 20, 14, 69, 45, 34);
//        List<Integer> num = numbers.stream().sorted().collect(Collectors.toList());
//        System.out.println(num);

        //sort all the gievn numbers & remove duplicate numbers
        List<Integer> numbers = Arrays.asList(10, 25, 36, 14, 20, 25, 36);
        List<Integer> res1 = numbers.stream().sorted().distinct().collect(Collectors.toList());
        System.out.println(res1);
    }
}
