package spring_annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import spring_annotation.service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;
    public void getUsers(){
        userService.getUser();
    }
}
