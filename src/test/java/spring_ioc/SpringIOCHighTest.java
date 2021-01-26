package spring_ioc;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIOCHighTest {
    ApplicationContext ioc;
    @Before
    public void before(){
        ioc=new ClassPathXmlApplicationContext("spring-ioc-high.xml");
    }

    /**
     * bean加载顺序，从上到下
     */
    @Test
    public void test01(){
        Person bean1=ioc.getBean("person",Person.class);
        Wife bean2= (Wife) ioc.getBean("wife");
        System.out.println(bean1);
        System.out.println(bean2);
    }

    /**
     * 懒加载
     */
    @Test
    public void test02(){
        System.out.println("spring 加载");
        Person bean1=ioc.getBean("person1",Person.class);
        Wife bean2= (Wife) ioc.getBean("wife1");
        System.out.println(bean1);
        System.out.println(bean2);
    }

    /**
     * 使用静态方法实例化对象
     */
    @Test
    public void test03(){
        Person bean1=ioc.getBean("person2",Person.class);
        System.out.println(bean1);
    }

    /**
     * 使用实例工厂方法实例化对象
     */
    @Test
    public void test04(){
        Person bean1=ioc.getBean("person3",Person.class);
        System.out.println(bean1);
    }
}
