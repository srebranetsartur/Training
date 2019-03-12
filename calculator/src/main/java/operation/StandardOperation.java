package operation;

public enum StandardOperation {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    TIMES("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String symbol;
    private Operation<Long> operation;

    StandardOperation(String symbol, Operation<Long> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String symbol() {
        return symbol;
    }

    public Operation<Long> operation() {
        return operation;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
