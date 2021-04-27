package guru.springframework.sfgpetclinic.service;

import guru.springframework.sfgpetclinic.model.Owner;

import java.util.Set;

public interface  CrudService<T, ID> {
    T findById( ID idField);
    Set<T> findAll();
    T save(T object);
    void delete(T object);
    void deleteById(ID id);
}
