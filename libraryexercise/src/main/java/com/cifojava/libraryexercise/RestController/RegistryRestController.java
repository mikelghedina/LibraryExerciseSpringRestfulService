package com.cifojava.libraryexercise.RestController;

import com.cifojava.libraryexercise.Service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegistryRestController {

    @Autowired
    private RegistryService registryService;



}
