package ru.eugene.graphql.FirstGraphQLApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eugene.graphql.FirstGraphQLApp.DTO.PersonDTO;
import ru.eugene.graphql.FirstGraphQLApp.DTO.PersonInput;
import ru.eugene.graphql.FirstGraphQLApp.models.Book;
import ru.eugene.graphql.FirstGraphQLApp.models.Person;
import ru.eugene.graphql.FirstGraphQLApp.repositories.BookRepository;
import ru.eugene.graphql.FirstGraphQLApp.repositories.PersonRepository;
import ru.eugene.graphql.FirstGraphQLApp.utils.PersonDTOConverter;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final BookRepository bookRepository;
    private final PersonDTOConverter personDTOConverter;

    @Autowired
    public PersonService(PersonRepository personRepository, BookRepository bookRepository) {
        this.personRepository = personRepository;
        this.bookRepository = bookRepository;
        this.personDTOConverter = new PersonDTOConverter();
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public PersonDTO findById(int id){
        Optional<Person>optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent())
            return personDTOConverter.toDTO(optionalPerson.get());
        else
            return null;
    }

    public List<PersonDTO> findAllDTO(){
        return personDTOConverter.toDTOList(personRepository.findAll());
    }

    public PersonDTO savePerson(PersonInput input){
        Person person = new Person(input.getName(), input.getSurname(), input.getAge());
        personRepository.save(person);
        return personDTOConverter.toDTO(person);
    }

    public PersonDTO addBook(int personId, int bookId){
        Optional<Person> personOptional = personRepository.findById(personId);
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        // TODO: сделать выброс исключения
        if(personOptional.isEmpty() || bookOptional.isEmpty())
            return null;

        Person person = personOptional.get();
        Book book = bookOptional.get();
        person.getBookList().add(book);
        book.setPerson(person);

        personRepository.save(person);  // update
        bookRepository.save(book);

        return personDTOConverter.toDTO(person);
    }

}
