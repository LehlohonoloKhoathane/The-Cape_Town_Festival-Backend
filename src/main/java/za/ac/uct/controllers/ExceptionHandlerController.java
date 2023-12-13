package za.ac.uct.controllers;
/**
 *
 * Author: Lehlohonolo Khoathane
 *
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import za.ac.uct.exception.EventNotAvailableException;
import za.ac.uct.exception.UserCantRentMoreThanOneEventException;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EventNotAvailableException.class)
    public ResponseEntity<String> handleEventNotAvailableException(EventNotAvailableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(UserCantRentMoreThanOneEventException.class)
    public ResponseEntity<String> handleUserCantRentMoreThanOneEventException(UserCantRentMoreThanOneEventException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
