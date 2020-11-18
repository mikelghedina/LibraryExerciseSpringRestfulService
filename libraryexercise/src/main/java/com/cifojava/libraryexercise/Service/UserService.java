package com.cifojava.libraryexercise.Service;


import com.cifojava.libraryexercise.Model.User;
import com.cifojava.libraryexercise.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> showUsers(){
        return userRepository.findAll();
    }

    public Optional<User> showOneUserById(Long id){
        return userRepository.findById(id);
    }

    public User insertUser(User user){
        userRepository.save(user);
        return user;
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }



}
