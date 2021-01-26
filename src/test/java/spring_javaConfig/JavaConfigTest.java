package spring_javaConfig;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_javaConfig.controller.UserController;

public class JavaConfigTest {
    AnnotationConfigApplicationContext ioc;
    @Before
    public void before(){
        //spring加载上下文
        ioc=new AnnotationConfigApplicationContext(IocJavaConfig.class);
    }
    @Test
    public void test01(){
        UserController bean= (UserController) ioc.getBean("userController");
        bean.getUsers();
    }
}
