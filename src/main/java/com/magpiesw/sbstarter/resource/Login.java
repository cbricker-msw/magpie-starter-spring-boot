package com.magpiesw.sbstarter.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.magpiesw.sbstarter.domain.User;

@RestController
@RequestMapping("/login")
public class Login
{

    @RequestMapping(method = RequestMethod.GET)
    public User login()
    {
        return new User(15L, "Magpie", "User");
    }

}
