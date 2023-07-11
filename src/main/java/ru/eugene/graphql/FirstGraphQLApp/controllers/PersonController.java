package ru.eugene.graphql.FirstGraphQLApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import ru.eugene.graphql.FirstGraphQLApp.models.Person;
import ru.eugene.graphql.FirstGraphQLApp.services.PersonService;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @QueryMapping(name = "persons")
    public Iterable<Person> people(){
        return personService.findAll();
    }

    

}
