package com.cifojava.libraryexercise.Repository;

import com.cifojava.libraryexercise.Model.Date;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DateRepository extends CrudRepository<Date, Long> {
}
