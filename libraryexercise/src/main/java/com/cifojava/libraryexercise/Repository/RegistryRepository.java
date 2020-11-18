package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Registry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistryRepository extends CrudRepository<Registry, Long> {

    void deleteById(Long id);
}
