package exceptions;

public class DuplicateUserException extends RuntimeException {
    private static final long serialVersionUID = -7796869661851371232L;

    public DuplicateUserException() { super(); }

    public DuplicateUserException(String message) { super(message); }

    public DuplicateUserException(Throwable cause) { super(cause); }

    public DuplicateUserException(String message, Throwable cause) { super(message, cause); }
}
