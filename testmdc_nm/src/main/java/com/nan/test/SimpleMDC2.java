package com.nan.test;

public class SimpleMDC2 {
    public static void main(String[] args) {
        new BizHandle("F0000").start();
        new BizHandle("F9999").start();
    }
}
