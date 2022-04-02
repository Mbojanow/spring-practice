package pl.sdacademy.springpractice.entities;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookCrudService {

    private final BookRepository bookRepository;

    public BookDto createBook(BookDto bookDto) {
        Book savedBook = bookRepository.save(toBook(bookDto));
        return toBookDto(savedBook);
    }

    public BookDto getBook(Long id) {
        return bookRepository.findById(id)
                .map(this::toBookDto)
                .orElseThrow(() -> new SdaException("Book with id " + id + " not found"));
    }

    public BookDto updateBook(Long id, BookDto bookDto) {
        return bookRepository.findById(id)
                .map(book -> { // do osobnej metody
                    book.setAuthor(bookDto.getAuthor());
                    book.setIsbn(bookDto.getIsbn());
                    book.setPages(bookDto.getPages());
                    book.setTitle(bookDto.getTitle());
                    return toBookDto(bookRepository.save(book));
                }).orElseThrow(() -> new SdaException("Book with id " + id + " not found"));
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private Book toBook(BookDto bookDto) {
        return new Book(bookDto.getId(),
                bookDto.getIsbn(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPages(),
                null); // dodać konstruktor bez tego pola
    }

    private BookDto toBookDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getIsbn(),
                book.getTitle(),
                book.getAuthor(),
                book.getPages()
        );
    }
}
