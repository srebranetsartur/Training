package validator;

/**
 * Common interface for validation purpose
 * By contract return a validate a valid object or throw exceptions
 * @param <T>
 */
@FunctionalInterface
public interface Validator<T> {
     T validate(T objToValidate);
}
