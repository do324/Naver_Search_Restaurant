package com.example.restaurant.db;

import java.util.List;
import java.util.Optional;

public interface MemoryDbRepositoryIfs<T> {

    Optional<T> findById(int index);    //해당 타입의 entity를 찾아서 return
    T save(T entity);
    void deleteById(int index);
    List<T> findAll();

}


