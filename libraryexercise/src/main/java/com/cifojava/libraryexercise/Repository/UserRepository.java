package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
