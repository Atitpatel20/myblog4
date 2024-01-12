package com.myblog4.myblog4;


public class Food {
    private String foodName;
    private String foodType;
    private long foodPrice;

    public String getFoodName() {
        return foodName;
    }

    public String getFoodType() {
        return foodType;
    }

    public long getFoodPrice() {
        return foodPrice;
    }

    public Food(String foodName, String foodType, long foodPrice) {
        this.foodName = foodName;
        this.foodType = foodType;
        this.foodPrice = foodPrice;
    }
}
