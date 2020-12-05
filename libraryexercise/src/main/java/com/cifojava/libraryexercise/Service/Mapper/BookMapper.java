package com.cifojava.libraryexercise.Service.Mapper;


import com.cifojava.libraryexercise.Model.Book;
import com.cifojava.libraryexercise.Model.Dto.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//@Mapper(componentModel = "spring")
public interface BookMapper {


    BookDto toBookDto(Book book);


    List<BookDto> toBookDTOs(List<Book> books);

}
