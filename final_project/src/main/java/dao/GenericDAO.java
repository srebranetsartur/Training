package dao;

import java.util.List;
import java.util.Optional;

public interface GenericDAO<T> {
    T save(T entity);

    void delete(T entity);

    T update(T entity);

    Optional<T> findById(Long id);

    List<T> findAll();

}
