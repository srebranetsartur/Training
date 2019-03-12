package operation;

public enum StringOperation {
    PLUS("+", String::concat);

    private String symbol;
    private Operation<String> operation;

    StringOperation(String symbol, Operation<String> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String symbol() {
        return symbol;
    }

    public Operation<String> operation() {
        return operation;
    }
}
