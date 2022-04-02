package pl.sdacademy.springpractice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private Long id;

    @NotNull(message = "Panie Zdzisiu, isbn cannot be empty")
    @Length(min = 13, max = 13, message = "isbn has be to 13 chars long")
    private String isbn;

    @NotNull(message = "title is empty")
    @Length(min = 2, message = "Title too short")
    private String title;

    @NotNull(message = "Author need to be provided")
    @Length(min = 2, message = "Author name too short")
    private String author;

    @NotNull(message = "pages needs to be provided")
    @Min(value = 1, message = "No Panie Zdzisiu, ujemna ilość stron?!")
    private Integer pages;
}
