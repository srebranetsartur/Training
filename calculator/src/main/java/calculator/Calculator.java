package calculator;

import operation.Operation;

import java.util.Objects;

public class Calculator<T> {

    public T process(T arg1, T arg2, Operation<T> operation) {
        Objects.requireNonNull(arg1);
        Objects.requireNonNull(arg2);

        return operation.accept(arg1, arg2);
    }
}
