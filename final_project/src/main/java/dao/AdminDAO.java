package dao;

import entities.Administrator;
import java.util.Optional;

public interface AdminDAO extends GenericDAO<Administrator> {
    Optional<Administrator> findByLoginAndPassword(String login, String password);
}
