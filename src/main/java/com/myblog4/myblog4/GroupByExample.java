package com.myblog4.myblog4;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByExample {
    public static void main(String[] args) {
        List<Food> foods = Arrays.asList(
                new Food("manchurian", "veg", 80),
                new Food("rice", "veg", 90),
                new Food("mamna", "nonVeg", 410),
                new Food("paneer", "veg", 120),
                new Food("chickenRice", "nonVeg", 80)
        );
        Map<String, List<Food>> collect = foods.stream().collect(Collectors.groupingBy(Food::getFoodType));

        for ( Map.Entry<String,List<Food>> entry:collect.entrySet() ) {
            String foodType = entry.getKey();
            List<Food> priceList = entry.getValue();
            System.out.println("Food Type:"+foodType+"---");
            for ( Food p: priceList) {
                System.out.println(p.getFoodName());
                System.out.println(p.getFoodPrice());
            }

        }


    }
}
