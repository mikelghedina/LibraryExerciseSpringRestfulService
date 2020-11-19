package com.cifojava.libraryexercise.RestController;


import com.cifojava.libraryexercise.Model.User;
import com.cifojava.libraryexercise.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class UserRestController {


    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Iterable<User> showUsers(){
        return userService.showUsers();
    }
    @GetMapping("/users{id}")
    public Optional<User> showUserById(@PathVariable Long id){
        return userService.showOneUserById(id);
    }
    @PostMapping("/users")
    public User insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }
    @PutMapping("/users{id}")
    public User editUser(@RequestBody User newUser, @PathVariable Long id){
        return userService.showOneUserById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    user.setAge(newUser.getAge());
                    return userService.insertUser(user);
                }).orElseGet(()->{
                   newUser.setId(id);
                   return userService.insertUser(newUser);
                });
    }

    @DeleteMapping("/users{id}")
    public void deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
    }
}
