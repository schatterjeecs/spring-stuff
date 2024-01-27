package org.sc.storeservice.repositories;

import org.sc.storeservice.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
