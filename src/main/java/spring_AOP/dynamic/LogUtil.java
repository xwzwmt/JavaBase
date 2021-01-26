package spring_AOP.dynamic;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
public class LogUtil {

    /*
    设置下面方法在什么时候运行
        @Before:在目标方法之前运行：前置通知
        @After:在目标方法之后运行：后置通知
        @AfterReturning:在目标方法正常返回之后：返回通知
        @AfterThrowing:在目标方法抛出异常后开始运行：异常通知
        @Around:环绕：环绕通知

        当编写完注解之后还需要设置在哪些方法上执行，使用表达式
        execution(访问修饰符  返回值类型 方法全称)
     */
    // 前置通知
    @Before("execution(* spring_javaConfig.service..*.*(..))")
    public static void before(JoinPoint point){
           /* System.out.println(method.getName()+"方法运行前，参数是"+
                    (args==null?"": Arrays.asList(args).toString()));*/

        System.out.println("方法前");
    }

    // 后置通知
    @After("execution(* spring_javaConfig.service..*.*(..))")
    public static void after(){
           /* System.out.println(method.getName() +"方法运行后，参数是"+
                    (args==null?"": Arrays.asList(args).toString()));*/
        System.out.println("方法后");
    }

    // 后置异常通知
    @AfterThrowing("execution(* spring_javaConfig.service..*.*(..))")
    public static void afterException(){
        // System.out.println("方法报错了:"+ex.getMessage());

        System.out.println("方法异常");
    }

    // 后置返回通知
    @AfterReturning("execution(* spring_javaConfig.service..*.*(..))")
    public static void afterEnd(){
        //System.out.println("方法结束，返回值是:"+returnValue);
        System.out.println("方法返回");

    }
}
