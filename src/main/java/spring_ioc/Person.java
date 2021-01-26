package spring_ioc;

import com.sun.media.jfxmediaimpl.MediaDisposer;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.List;
import java.util.Map;

public class Person implements InitializingBean, DisposableBean {
    public void setId(Integer id) {
        this.id = id;
    }

    public void setHobiles(List<String> hobiles) {
        this.hobiles = hobiles;
    }

    public void setCourse(Map<Integer, String> course) {
        this.course = course;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    public Person() {
        System.out.println("Person加载");
    }

    public static Person createPersonFactory(){
        Child child=new Child();
        child.setId(520);
        return child;
    }

    private Integer id;
    private List<String> hobiles;
    private Map<Integer,String> course;
    private Wife wife;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"hobiles\":")
                .append(hobiles);
        sb.append(",\"course\":")
                .append(course);
        sb.append(",\"wife\":")
                .append(wife);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("实例化person");
    }

    @Override
    public void destroy() throws Exception {
//        在ioc容器关闭的时候才会去销毁
        System.out.println("销毁person");
    }
}
