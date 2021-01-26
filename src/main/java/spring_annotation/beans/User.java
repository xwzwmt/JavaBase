package spring_annotation.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class User {
    /**
     * 使用@Value设置依赖注入
     * 还可以写${}、#{}
     */

//    @Value("wmt")
//            从外部依赖文件中获取属性
//      @Value("${mysql.name}")
            @Value("#{role.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
