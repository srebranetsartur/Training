package dao;


import entities.Visitor;
import java.util.Optional;

public interface VisitorDAO extends GenericDAO<Visitor>{
    Optional<Visitor> findByNumber(String number);
}

