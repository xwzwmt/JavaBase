package spring_javaConfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring_javaConfig.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    public void getUsers(){
        userService.getUser();
    }
}
