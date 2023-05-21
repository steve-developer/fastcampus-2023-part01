package com.example.session.controller;

import com.example.session.model.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @GetMapping("/me")
    public UserDto me(
        HttpSession httpSession
    ){
        var userObject = httpSession.getAttribute("USER");

        if(userObject != null){
            var userDto = (UserDto) userObject;
            return userDto;
        }else{
            return null;
        }
    }
}
