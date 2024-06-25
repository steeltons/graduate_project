package org.jenjetsu.graduate_project.service;

import java.io.Serializable;
import java.util.List;

public interface CrudService<E, ID extends Serializable> {
    
    public E readById(ID id);
    public List<E> readAll();
    public E create(E raw);
    public E update(E raw);
    public E deleteById(ID id);
    public boolean existsById(ID id);
    
}
