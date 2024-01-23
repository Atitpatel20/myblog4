package com.myblog4.myblog4;

public class SampleClass {

    public static int test1() {
        SampleClass simpleClass= new SampleClass();
        int otp = SampleClass.returnOtp();
        return otp;
    }

    private static int returnOtp() {
        return 214596;
    }
}
