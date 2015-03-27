package freeplace.lla.model.data.service;

import java.util.List;

/**
 * Created by klymenko.ruslan on 22.03.2015.
 */
public interface BasicService<T> {
    T add(T object);
    T update(T object);
    void delete(T object);
    List<T> findAll();
    T findById(Long id);
}
