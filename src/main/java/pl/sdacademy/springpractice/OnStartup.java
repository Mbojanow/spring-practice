package pl.sdacademy.springpractice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pl.sdacademy.springpractice.entities.Book;
import pl.sdacademy.springpractice.entities.BookRepository;

import java.util.List;

@Profile("local1")
@Component
//@RequiredArgsConstructor
public class OnStartup implements CommandLineRunner {

    @Value("${variablea}")
    private String variableAValue;

    @Value("${variableb}")
    private String variablebValue;

    private final SomeClassA someClassA;
    private final SomeClassB someClassB;
    private final SomeClassC someClassC;
    private final InterfaceA interfaceA;
    private final List<InterfaceA> interfaces;
    private final BookRepository bookRepository;

    public OnStartup(SomeClassA someClassA, SomeClassB someClassB, SomeClassC someClassC,
            /*@Qualifier("classB2")*/ InterfaceA interfaceA, List<InterfaceA> interfaces, BookRepository bookRepository) {
        this.someClassA = someClassA;
        this.someClassB = someClassB;
        this.someClassC = someClassC;
        this.interfaceA = interfaceA;
        this.interfaces = interfaces;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(variableAValue + variablebValue);
        interfaceA.hi();
        bookRepository.save(new Book(null,
                "1234",
                "Jak pisać w springu",
                "Andrzej",
                5, null));
    }
}
