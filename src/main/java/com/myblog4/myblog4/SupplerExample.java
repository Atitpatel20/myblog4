package com.myblog4.myblog4;

import java.util.Random;
import java.util.function.Supplier;

public class SupplerExample {
    public static void main(String[] args) {
        Supplier<Integer>val=()-> new Random().nextInt(500);
        Integer y = val.get();
        System.out.println(y);
    }
}
