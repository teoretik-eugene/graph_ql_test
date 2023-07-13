package ru.eugene.graphql.FirstGraphQLApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.eugene.graphql.FirstGraphQLApp.DTO.BookDTO;
import ru.eugene.graphql.FirstGraphQLApp.models.Book;
import ru.eugene.graphql.FirstGraphQLApp.services.BookService;
import ru.eugene.graphql.FirstGraphQLApp.services.PersonService;

@Controller
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping(name = "books")
    public Iterable<BookDTO> books(){
        return bookService.findAllDTO();
    }

    @QueryMapping(name = "book")
    public BookDTO getBookById(@Argument int id){
        return bookService.getBookById(id);
    }

    @MutationMapping(name = "addBook")
    public BookDTO addBook(@Argument(name = "book") BookInput bookInput) {
        return bookService.saveBook(bookInput.title(), bookInput.author());
    }

    record BookInput(String title, String author) { }
}
