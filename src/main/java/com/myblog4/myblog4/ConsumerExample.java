package com.myblog4.myblog4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<String>val= names-> System.out.println(names);
        val.accept("mike");

        List<String> names = Arrays.asList("mike", "stallin", "vijay");
        Consumer<String>data=name-> System.out.println(name);
        names.forEach(data);
    }
}
