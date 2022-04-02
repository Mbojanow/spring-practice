package pl.sdacademy.springpractice.entities;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

//klasa odpowiedzialna za obsługę wyjątków
@RestControllerAdvice // @ControllerAdvice + @ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SdaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handle(SdaException exception) {
        log.warn("Exception occurred", exception);
        return new Error(exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error handle(MethodArgumentNotValidException exception) {
        List<String> details = exception.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .filter(Objects::nonNull)
                .toList();
        return new Error("Input invalid", details);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Error handle(Exception exception) {
        log.error("Error occurred", exception);
        return new Error("Unexpected error occurred. This is not your fault");
    }

}
