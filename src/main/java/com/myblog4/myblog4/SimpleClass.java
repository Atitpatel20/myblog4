package com.myblog4.myblog4;

public class SimpleClass {

    public static int test1() {
        SimpleClass simpleClass= new SimpleClass();
        int otp = SimpleClass.returnOtp();
        return otp;
    }

    private static int returnOtp() {
        return 214596;
    }
}
