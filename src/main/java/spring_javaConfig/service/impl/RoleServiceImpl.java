package spring_javaConfig.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring_javaConfig.dao.UserDao;
import spring_javaConfig.service.UserService;

@Service
public class RoleServiceImpl implements UserService {
    @Autowired
    UserDao userDao;
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
