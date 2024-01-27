package org.sc.storeservice.services;

import org.sc.storeservice.domain.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class BookServicePrimary implements BookService{

    @Override
    public Iterable<Book> findAll() {
        return null;
    }
}
