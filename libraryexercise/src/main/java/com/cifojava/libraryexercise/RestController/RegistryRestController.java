package com.cifojava.libraryexercise.RestController;

import com.cifojava.libraryexercise.Model.Registry;
import com.cifojava.libraryexercise.Service.RegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class RegistryRestController {

    @Autowired
    private RegistryService registryService;

    @GetMapping("/registries")
    public Iterable<Registry> showRegistries(){
        return registryService.showRegistry();
    }
    @GetMapping("/registries{id}")
    public Optional<Registry> showOneRegistryById(@PathVariable Long id){
        return registryService.findOneRegistryById(id);
    }
    @PostMapping("/registries")
    public Registry insertRegistry(@RequestBody Registry registry){
        registryService.insertRegistry(registry);
        return registry;
    }
    @DeleteMapping("/registries{id}")
    public void deleteRegistryById(@PathVariable Long id){
        registryService.deleteRegistryById(id);
    }
}
