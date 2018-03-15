package pl.lukasz.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.lukasz.spring5webapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
