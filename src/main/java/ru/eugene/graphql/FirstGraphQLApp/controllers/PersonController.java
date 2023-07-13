package ru.eugene.graphql.FirstGraphQLApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import ru.eugene.graphql.FirstGraphQLApp.DTO.BookDTO;
import ru.eugene.graphql.FirstGraphQLApp.DTO.PersonDTO;
import ru.eugene.graphql.FirstGraphQLApp.DTO.PersonInput;
import ru.eugene.graphql.FirstGraphQLApp.models.Person;
import ru.eugene.graphql.FirstGraphQLApp.services.BookService;
import ru.eugene.graphql.FirstGraphQLApp.services.PersonService;

import java.util.List;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @QueryMapping(name = "persons")
    public Iterable<PersonDTO> people(){
        return personService.findAllDTO();
    }

    /*      Этот метод, если названия полей не совпадают
    @SchemaMapping(typeName = "Person", field = "books")
    public List<BookDTO> getBooks(PersonDTO personDTO){
        return personDTO.getBooks();
    }*/

    @QueryMapping(name = "person")
    public PersonDTO getPersonById(@Argument int id){
        return personService.findById(id);
    }

    @MutationMapping(name = "addPerson")
    public PersonDTO add(@Argument(name = "person") PersonInput personInput){
        return personService.savePerson(personInput);
    }

    @MutationMapping(name = "addBookToPerson")
    public PersonDTO addBookToPerson(@Argument(name = "personId") int personId,
                                         @Argument(name = "bookId") int bookId) {
        return personService.addBook(personId, bookId);
    }
}

