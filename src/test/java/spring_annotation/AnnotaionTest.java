package spring_annotation;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_annotation.beans.User;
import spring_annotation.controller.UserController;
import spring_annotation.service.UserService;
import spring_annotation.service.impl.UserServiceImpl;

public class AnnotaionTest {
    ClassPathXmlApplicationContext ioc;
    @Before
    public void before(){
        ioc=new ClassPathXmlApplicationContext("spring_annotation.xml");
    }

    @Test
    public void test1(){
        UserController bean=(UserController) ioc.getBean("userController");
        System.out.println(bean.getClass());
        UserService bean1=(UserService) ioc.getBean("userService");
        bean1.getUser();
    }

    /**
     * 测试@value
     */
    @Test
    public void test2(){
        User bean=(User) ioc.getBean("user");
        System.out.println(bean.getName());
    }

    /**
     * 测试自动装配
     */
    @Test
    public void test3(){
        UserController bean=(UserController) ioc.getBean("userController");
        bean.getUsers();
    }
}
