package org.sc.storeservice.repositories;

import org.sc.storeservice.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
