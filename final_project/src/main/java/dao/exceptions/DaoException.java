package dao.exceptions;

public class DaoException extends RuntimeException {
    public DaoException() {
    }

    public DaoException(String message) {

    }

    public DaoException(Exception e) {
        super(e);
    }


}
