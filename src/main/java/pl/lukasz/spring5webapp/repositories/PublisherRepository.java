package pl.lukasz.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.lukasz.spring5webapp.model.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
