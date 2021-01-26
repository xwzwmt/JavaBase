package spring_annotation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import spring_annotation.dao.UserDao;
import spring_annotation.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public void getUser() {
        userDao.getUser();
    }
}
