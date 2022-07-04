package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityExistsException;
import java.util.*;

@ControllerAdvice
public class ExceptionProcessor {//обработчик для контроллера и

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Object> handleEntityExistsException(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception ex) {
        List<String> stackTrace = Arrays.stream(ex.getStackTrace()).map(Objects::toString).toList();
        return new ResponseEntity<>(ex.getStackTrace(), HttpStatus.BAD_REQUEST);
    }
}