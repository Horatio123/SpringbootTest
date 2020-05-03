package com.baimahu.SpringbootBasic.bean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class CalculatorLoggingProxy {

    private Calculator target;

    public CalculatorLoggingProxy(Calculator calculator) {
        this.target = calculator;
    }

    public Calculator getLoggingProxy() {
        Calculator proxy;
        ClassLoader loader = target.getClass().getClassLoader();
        Class[] interfaces = new Class[]{Calculator.class};
        InvocationHandler handler = (o, method, objects) -> {
            System.out.println("before method " + method.getName() + Arrays.asList(objects));
            Object result = null;
            try {
                result = method.invoke(target, objects);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("after method = " + result);
            return result;
        };
        proxy = (Calculator) Proxy.newProxyInstance(loader, interfaces, handler);
        return proxy;
    }
}
