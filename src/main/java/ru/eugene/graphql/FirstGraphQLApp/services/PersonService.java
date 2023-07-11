package ru.eugene.graphql.FirstGraphQLApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.eugene.graphql.FirstGraphQLApp.models.Person;
import ru.eugene.graphql.FirstGraphQLApp.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Person findById(int id){
        Optional<Person>optionalPerson = personRepository.findById(id);
        if(optionalPerson.isPresent())
            return optionalPerson.get();
        else
            return null;
    }

}
