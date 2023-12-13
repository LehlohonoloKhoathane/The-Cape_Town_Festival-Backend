package za.ac.uct.exception;
/**
 *
 * Author: Lehlohonolo Khoathane
 *
 */
public class UserCantRentMoreThanOneEventException extends RuntimeException {
    public UserCantRentMoreThanOneEventException(String message) {
        super(message);
    }
}
