package task2;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * List exclude remove operation
 * All the undocumented method copy the list implementation
 * @param <E>
 */
public class UnmodifiableList<E> {
    private List<E> list;

    /**
     * Default init a inner list
     */
    public UnmodifiableList() {
        list = new ArrayList<>();
    }

    public UnmodifiableList(List<E> list) {
        Objects.requireNonNull(list);
        this.list = list;
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(Object o) {
        return list.contains(o);
    }

    public Iterator<E> iterator() {
        return list.iterator();
    }

    public Object[] toArray() {
        return list.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    public boolean add(E e) {
        return list.add(e);
    }

    /**
     * @throws @{@link UnsupportedOperationException}
     * @param o
     * @return nothing
     */
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> c) {
        return list.containsAll(c);
    }

    public boolean addAll(Collection<? extends E> c) {
        return list.addAll(c);
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return list.addAll(index, c);
    }

    /**
     * @throws @{@link UnsupportedOperationException}
     * @param c
     * @return
     */
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> c) {
        return list.retainAll(c);
    }

    public void replaceAll(UnaryOperator<E> operator) {
        list.replaceAll(operator);
    }

    public void sort(Comparator<? super E> c) {
        list.sort(c);
    }

    public void clear() {
        list.clear();
    }

    @Override
    public boolean equals(Object o) {
        return list.equals(o);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    public E get(int index) {
        return list.get(index);
    }

    public E set(int index, E element) {
        return list.set(index, element);
    }

    public void add(int index, E element) {
        list.add(index, element);
    }

    public E remove(int index) {
        return list.remove(index);
    }

    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    public int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    public ListIterator<E> listIterator() {
        return list.listIterator();
    }

    public ListIterator<E> listIterator(int index) {
        return list.listIterator(index);
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    public Spliterator<E> spliterator() {
        return list.spliterator();
    }

    public boolean removeIf(Predicate<? super E> filter) {
        return list.removeIf(filter);
    }

    public Stream<E> stream() {
        return list.stream();
    }

    public Stream<E> parallelStream() {
        return list.parallelStream();
    }

    public void forEach(Consumer<? super E> action) {
        list.forEach(action);
    }
}
