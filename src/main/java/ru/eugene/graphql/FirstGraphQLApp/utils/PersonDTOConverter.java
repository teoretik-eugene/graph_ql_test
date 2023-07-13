package ru.eugene.graphql.FirstGraphQLApp.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.eugene.graphql.FirstGraphQLApp.DTO.PersonDTO;
import ru.eugene.graphql.FirstGraphQLApp.models.Person;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PersonDTOConverter {

    private final ModelMapper mapper;
    private BookDTOConverter bookDTOConverter;

    public PersonDTOConverter() {
        this.mapper = new ModelMapper();
        this.bookDTOConverter = new BookDTOConverter();

    }

    public List<PersonDTO> toDTOList(List<Person> personList){
        List<PersonDTO> DTOList = personList.stream()
                .map(v->{
                    PersonDTO personDTO = mapper.map(v, PersonDTO.class);
                    personDTO.setBooks(bookDTOConverter.toDTOList(v.getBookList()));
                    return personDTO;
                })
                .toList();
        return DTOList;
    }

    public PersonDTO toDTO(Person person){
        PersonDTO personDTO = mapper.map(person, PersonDTO.class);
        if(person.getBookList() == null)
            personDTO.setBooks(Collections.emptyList());
        else
            personDTO.setBooks(bookDTOConverter.toDTOList(person.getBookList()));
        return personDTO;
    }
}
