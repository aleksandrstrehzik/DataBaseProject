package DAO.Interfaces;

import java.util.List;

public interface DAO<T> {

    T findById(Integer id);

    void deleteById(Integer id);

    List<T> findAll();

    void save(T t);

    void update(T t);

}
