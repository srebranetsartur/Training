package operation;

@FunctionalInterface
public interface Operation<T> {
    T accept(T a, T b);
}
