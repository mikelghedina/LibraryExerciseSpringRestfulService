package com.cifojava.libraryexercise.Service;


import com.cifojava.libraryexercise.Model.Registry;
import com.cifojava.libraryexercise.Repository.RegistryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class RegistryService {

    @Autowired
    private RegistryRepository registryRepository;


    public Iterable<Registry> showRegistry(){
        return registryRepository.findAll();
    }

    public Optional<Registry> findOneRegistryById(Long id){
        return registryRepository.findById(id);
    }

    public Registry insertRegistry(Registry registry){
        return registryRepository.save(registry);
    }

    public void deleteRegistryById(Long id){
        registryRepository.deleteById(id);
    }


}
