package org.sc.storeservice.bootstrap;

import org.sc.storeservice.domain.Author;
import org.sc.storeservice.domain.Book;
import org.sc.storeservice.domain.Publisher;
import org.sc.storeservice.repositories.AuthorRepository;
import org.sc.storeservice.repositories.BookRepository;
import org.sc.storeservice.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository,
                         BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("In bootstrap...");
        Author authObj = new Author();
        authObj.setFirstName("auth2");
        authObj.setLastName("authl2");
        Author savedAuthObj = authorRepository.save(authObj);

        Book bookObj = new Book();
        bookObj.setTitle("Beauty book");
        bookObj.setIsbn("2435dgdfy5r657567");
        Book savedBookObj = bookRepository.save(bookObj);

        Book bookObj1 = new Book();
        bookObj1.setTitle("Beauty book1");
        bookObj1.setIsbn("2435dgsf");
        Book savedBookObj1 = bookRepository.save(bookObj1);

        Set<Book> books = new HashSet<>(List.of(bookObj, bookObj1));

        savedAuthObj.setBooks(books);
        savedBookObj1.getAuthors().add(savedAuthObj);
        authorRepository.save(savedAuthObj);
        bookRepository.save(savedBookObj1);

        authorRepository.saveAll(
                List.of(
                        new Author("auth1", "authl1"),
                        new Author("auth3", "authl3")
                )
        );

        bookRepository.saveAll(
                List.of(
                        new Book("bookish", "23rs35"),
                        new Book("domain driven design", "32546t56")
                )
        );

        Publisher pubObj = new Publisher();
        pubObj.setName("pub1");
        pubObj.setAddress("some address");
        Publisher savedPubObj = publisherRepository.save(pubObj);

        savedBookObj.setPublisher(savedPubObj);
        bookRepository.save(savedBookObj);

        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());

    }
}
