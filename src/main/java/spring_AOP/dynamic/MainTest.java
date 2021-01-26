package spring_AOP.dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_javaConfig.service.UserService;
import spring_javaConfig.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class MainTest {
    /**
     * jdk
     *
     *不需要为每个类都创建代理类
     * ClassLoader loader,类加载器，指定的被代理类的接口的类加载器
     *  Class<?>[] interfaces,类型，指定被代理类的接口类型
     *  InvocationHandler h委托执行的处理类
     */
    @Test
    public void  test(){
        ClassLoader classLoader=ICalculator.class.getClassLoader();
        Class<?>[] interfaces=new Class[]{ICalculator.class};
        InvocationHandler handler=new MyinvocationHandler(new Calculator());
        //动态创建代理类
        ICalculator o=(ICalculator) Proxy.newProxyInstance(classLoader,interfaces,handler);
        System.out.println(o.getClass());
        System.out.println(o.add(1,1));
    }

    @Test
    public void test1(){
        ClassPathXmlApplicationContext ioc=new ClassPathXmlApplicationContext("classpath:/spring_annotation.xml");
        UserServiceImpl bean= (UserServiceImpl) ioc.getBean("userServiceImpl");
        bean.getUser();
    }
}
