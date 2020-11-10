package com.cifojava.libraryexercise.Service;


import com.cifojava.libraryexercise.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


}
