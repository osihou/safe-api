package com.projectpl.safeapi.controller;

import com.projectpl.safeapi.persistance.entity.User;
import com.projectpl.safeapi.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(
            path = "/users/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public User getUserById(
            @PathVariable long id
    ){
        return userService.getUserById(id);

    }

    @RequestMapping(
            path = "/users/all",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Iterable<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(
            path = "/users/hash/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getUserHash(
            @PathVariable long id
    ){
        return userService.getUserById(id).hashUser();
    }

    //TBD
    @RequestMapping(
            path = "/users",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void postUser(
            @RequestBody User user
    ){
        userService.saveRegisteredUser(user);
    }

    @RequestMapping(
            path = "/users/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void deleteUserById(
            @PathVariable long id
    ){
        userService.deleteUserById(id);
    }

}
