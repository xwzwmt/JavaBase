package spring_AOP.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyinvocationHandler implements InvocationHandler {
//    被处理的对象
    Object target;
    public MyinvocationHandler(Object target){
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("日志：调用了add方法，参数是："+ Arrays.asList(args));
/**
 *O bject obj,被代理的对象
 *  Object... args 被代理的方法参数，直接将args传进去
 *
 */
        Object result=method.invoke(target,args);
        System.out.println("日志："+result);
        return result;
    }
}
