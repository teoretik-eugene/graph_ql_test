package ru.eugene.graphql.FirstGraphQLApp.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import ru.eugene.graphql.FirstGraphQLApp.models.Book;

import java.util.List;

public class PersonDTO {

    private String name;
    private String surname;
    private int age;
    private List<BookDTO> books;

    public PersonDTO() {
    }

    public PersonDTO(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
