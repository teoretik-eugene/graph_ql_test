package ru.eugene.graphql.FirstGraphQLApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.eugene.graphql.FirstGraphQLApp.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
