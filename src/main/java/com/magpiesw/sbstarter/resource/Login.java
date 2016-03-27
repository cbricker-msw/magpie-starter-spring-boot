package com.magpiesw.sbstarter.resource;

import com.magpiesw.sbstarter.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
