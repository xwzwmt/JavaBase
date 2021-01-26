package spring_ioc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    ApplicationContext ioc;
    @Before
    public void beforerun(){
        //加载spring容器
        //ApplicationContext是spring的顶层核心接口
        //在容器实例化的时候，会加重所有的bean
         ioc = new ClassPathXmlApplicationContext("spring-ioc.xml");
        System.out.println("spring 容器已加载");
    }
    @Test
    public void test01(){

        //1、通过类来获取bean 当配置文件中有两个类对象时不起作用
//        User bean=ioc.getBean(User.class);
        //2、通过bean的名字或者id来获取bean (User) ioc.getBean("user");
//        3、通过名字+类型
        User bean=ioc.getBean("user",User.class);
//        通过反射获得实例化对象
//        User user=User.class.newInstance();
        System.out.println(bean);

//        测试别名
        User bean1=ioc.getBean("name1",User.class);
        User bean2=ioc.getBean("user3",User.class);
        System.out.println(bean1);
        System.out.println(bean2);
    }

    /*
    测试依赖注入
     */
    @Test
    public void test02(){
        User bean1=ioc.getBean("user6",User.class);
        System.out.println(bean1);

        User bean2=ioc.getBean("user7",User.class);
        System.out.println(bean2);
    }

    /**
     * 复杂数据依赖注入
     */
    @Test
    public void test03(){
        Person bean1=ioc.getBean("person1",Person.class);
        System.out.println(bean1);

    }
    /**
     * p命名空间
     */
    @Test
    public void test04(){
        Person bean1=ioc.getBean("person2",Person.class);
        System.out.println(bean1);
    }

    /**
     * c命名空间
     */
    @Test
    public void test05(){
        Wife bean1=ioc.getBean("wifezyl",Wife.class);
        System.out.println(bean1);
    }
}
