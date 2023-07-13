package ru.eugene.graphql.FirstGraphQLApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eugene.graphql.FirstGraphQLApp.DTO.BookDTO;
import ru.eugene.graphql.FirstGraphQLApp.models.Book;
import ru.eugene.graphql.FirstGraphQLApp.repositories.BookRepository;
import ru.eugene.graphql.FirstGraphQLApp.utils.BookDTOConverter;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookDTOConverter bookDTOConverter;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.bookDTOConverter = new BookDTOConverter();
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }

    public List<BookDTO> findAllDTO(){
        return bookDTOConverter.toDTOList(bookRepository.findAll());
    }

    public BookDTO getBookById(int id){
        Optional<Book> optional = bookRepository.findById(id);
        if(optional.isPresent())
            return bookDTOConverter.toDTO(optional.get());
        return null;
    }

    public BookDTO saveBook(String title, String author) {
        Book book = new Book(title, author);
        bookRepository.save(book);
        return bookDTOConverter.toDTO(book);
    }

}
