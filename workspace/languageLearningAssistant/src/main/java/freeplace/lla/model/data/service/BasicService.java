package freeplace.lla.model.data.service;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * Created by klymenko.ruslan on 30.03.2015.
 */
public abstract class BasicService<K extends JpaRepository<? super V,Long>,V> {

    protected K jpaRepository;

    public V add(V object) { return jpaRepository.saveAndFlush(object);  }

    public V update(V object) {
        return jpaRepository.saveAndFlush(object);
    }

    public void delete(V object) {
        jpaRepository.delete(object);
    }

    public List<V> findAll() {
        return (List<V>) jpaRepository.findAll();
    }

    public V findById(Long id) {
        return (V) jpaRepository.findOne(id);
    }
}
