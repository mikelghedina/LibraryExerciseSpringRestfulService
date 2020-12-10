package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Registry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
//When we use a custom method to make request to our database, the persistence context is not setted by default,
//otherwise default methods are already configured by spring so that's why we need to use Transactional annotation in
//order to use our custom methods and not get any possible error.
@Repository
public interface RegistryRepository extends CrudRepository<Registry, Long> {

    @Transactional
    void deleteById(Long id);
}
