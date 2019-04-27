package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Dinara I. on 27.04.2019.
 */
public class CustomInvocationHandler implements InvocationHandler {
    SomeInterfaceWithMethods target;

    public CustomInvocationHandler(SomeInterfaceWithMethods target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " in");
        Object res = method.invoke(target, args);
        System.out.println(method.getName() + " out");
        return res;
    }
}
