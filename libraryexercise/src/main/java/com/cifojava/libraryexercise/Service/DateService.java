package com.cifojava.libraryexercise.Service;


import com.cifojava.libraryexercise.Repository.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DateService {

    @Autowired
    private DateRepository dateRepository;


}
