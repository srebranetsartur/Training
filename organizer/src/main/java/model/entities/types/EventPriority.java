package model.entities.types;

public enum EventPriority {
    DEFAULT(0), LOW(1), MEDIUM(2), HIGH(3), EXTREME_HIGH(4);

    private int priority;

    EventPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
