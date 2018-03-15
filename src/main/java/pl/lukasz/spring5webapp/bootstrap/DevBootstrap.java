package pl.lukasz.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import pl.lukasz.spring5webapp.model.Author;
import pl.lukasz.spring5webapp.model.Book;
import pl.lukasz.spring5webapp.model.Publisher;
import pl.lukasz.spring5webapp.repositories.AuthorRepository;
import pl.lukasz.spring5webapp.repositories.BookRepository;
import pl.lukasz.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Geralt
        Publisher aaa = new Publisher();
        aaa.setName("costam");
        publisherRepository.save(aaa);
        Author geralt = new Author("Geralt","Z Rivii");
        Book fraszka = new Book("Lambert Lambert ty chuju", "12332", aaa);
        geralt.getBooks().add(fraszka);
        fraszka.getAuthors().add(geralt);

        authorRepository.save(geralt);
        bookRepository.save(fraszka);

        //Lukasz
        Author lukasz = new Author("Lukasz", "Woowi");
        Book nic = new Book("Nic ciekawego", "6535", aaa);
        lukasz.getBooks().add(nic);
        nic.getAuthors().add(lukasz);

        authorRepository.save(lukasz);
        bookRepository.save(nic);
    }
}
