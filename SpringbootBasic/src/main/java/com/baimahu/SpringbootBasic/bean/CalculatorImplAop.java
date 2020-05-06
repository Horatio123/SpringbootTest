package com.baimahu.SpringbootBasic.bean;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImplAop implements Calculator{
    @Override
    public int add(int i, int j) {
        return i + j;
    }

    @Override
    public int sub(int i, int j) {
        return i - j;
    }

    public CalculatorImplAop() {
    }

}