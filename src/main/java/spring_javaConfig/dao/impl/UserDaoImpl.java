package spring_javaConfig.dao.impl;

import org.springframework.stereotype.Repository;
import spring_javaConfig.dao.UserDao;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("操作数据库");
    }
}
