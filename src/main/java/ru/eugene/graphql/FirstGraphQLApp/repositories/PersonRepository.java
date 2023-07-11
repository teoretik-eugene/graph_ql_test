package ru.eugene.graphql.FirstGraphQLApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eugene.graphql.FirstGraphQLApp.models.Person;

import java.util.ArrayList;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {


}
