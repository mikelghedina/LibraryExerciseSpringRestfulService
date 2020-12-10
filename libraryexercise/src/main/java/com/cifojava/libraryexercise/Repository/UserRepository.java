package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//When we use a custom method to make request to our database, the persistence context is not setted by default,
//otherwise default methods are already configured by spring so that's why we need to use Transactional annotation in
//order to use our custom methods and not get any possible error.
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
