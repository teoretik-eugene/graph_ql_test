package ru.eugene.graphql.FirstGraphQLApp.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.eugene.graphql.FirstGraphQLApp.DTO.BookDTO;
import ru.eugene.graphql.FirstGraphQLApp.DTO.PersonDTO;
import ru.eugene.graphql.FirstGraphQLApp.models.Book;

import java.util.List;

public class BookDTOConverter {

    private final ModelMapper mapper;


    public BookDTOConverter() {
        this.mapper = new ModelMapper();
    }

    public List<BookDTO> toDTOList(List<Book> books){
        return books.stream().map(v->mapper.map(v, BookDTO.class)).toList();
    }

    public BookDTO toDTO(Book book){
        return mapper.map(book, BookDTO.class);
    }
}
