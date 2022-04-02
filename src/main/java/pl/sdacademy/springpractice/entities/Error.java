package pl.sdacademy.springpractice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    private String message;
    private List<String> details;

    public Error(String message) {
        this.message = message;
        details = List.of();
    }
}
