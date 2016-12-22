package ua.sumdu.j2se.kryshtop.tasks.Exceptions;

public class InvalidTaskIndexException extends ArrayIndexOutOfBoundsException {
    public InvalidTaskIndexException() {
    }

    public InvalidTaskIndexException(String message) {
        super(message);
    }
}
