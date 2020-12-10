package com.cifojava.libraryexercise.Service.Mapper;


import com.cifojava.libraryexercise.Model.Book;
import com.cifojava.libraryexercise.Model.Dto.BookDto;


import java.util.List;
//This is a try using the mapperStruct to implement DTO in this project. Got no time for that, So it is not used also not implemented either.
//@Mapper(componentModel = "spring")
public interface BookMapper {


    BookDto toBookDto(Book book);


    List<BookDto> toBookDTOs(List<Book> books);

}
