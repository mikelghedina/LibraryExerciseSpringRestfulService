package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
