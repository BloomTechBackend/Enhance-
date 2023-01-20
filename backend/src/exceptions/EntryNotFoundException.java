package exceptions;

public class EntryNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -7427828855662071824L;

    public EntryNotFoundException() {
        super();
    }

    public EntryNotFoundException(String message) {
        super(message);
    }

    public EntryNotFoundException(Throwable cause) {
        super(cause);
    }

    public EntryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
