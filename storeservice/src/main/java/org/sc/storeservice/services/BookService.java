package org.sc.storeservice.services;

import org.sc.storeservice.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
