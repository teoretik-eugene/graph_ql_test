package ru.eugene.graphql.FirstGraphQLApp.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eugene.graphql.FirstGraphQLApp.DTO.PersonDTO;
import ru.eugene.graphql.FirstGraphQLApp.models.Person;
import ru.eugene.graphql.FirstGraphQLApp.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class RestPersonController {

    private final PersonService personService;

    @Autowired
    public RestPersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public List<PersonDTO> getAll(){
        return personService.findAllDTO();
    }

    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable int id){
        return personService.findById(id);
    }



}
