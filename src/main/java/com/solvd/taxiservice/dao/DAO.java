package dao;

import java.util.List;


public interface DAO<T> {
    
    int insert(T t);
    int update(T t);
    int deleteById(int id);
    T getById(int id);
    List<T> getAll();
    
}
