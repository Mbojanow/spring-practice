package pl.sdacademy.springpractice.entities;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController // @Controller + @ResponseBody
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookCrudService bookCrudService;

    @GetMapping("/{id}")
    public BookDto findBook(@PathVariable(name = "id") Long id) {
        return bookCrudService.getBook(id);
//        return ResponseEntity.status(200)
//                .header("x-custom", "v1")
//                .body(bookCrudService.getBook(id)); // i zwracamy ResponseEntity<BookDto>
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto createBook(@RequestBody BookDto bookDto) {
        return bookCrudService.createBook(bookDto);
    }

}
