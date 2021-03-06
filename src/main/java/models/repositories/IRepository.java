package models.repositories;

import java.io.Serializable;
import java.util.List;

public interface IRepository <T, Id extends Serializable>{

    void save (T entity);
    void update (T entity);
    T findById(int id);
    void delete (T entity);
    List<T> findAll();
    void deleteAll();


}
