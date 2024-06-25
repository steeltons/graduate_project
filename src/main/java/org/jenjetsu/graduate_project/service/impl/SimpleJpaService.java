package org.jenjetsu.graduate_project.service.impl;

import static java.lang.String.format;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jenjetsu.graduate_project.exception.*;
import org.jenjetsu.graduate_project.service.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleJpaService<E, ID extends Serializable> implements CrudService<E, ID> {

    private final JpaRepository<E, ID> jpaRepository;

    private final Class<? extends E> clazz;

    public SimpleJpaService(
        Class<? extends E> mappedClass,
        JpaRepository<E, ID> jpaRepository
    ) {
        this.clazz = mappedClass;
        this.jpaRepository = jpaRepository;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public E create(E raw) {
        var newEntity = jpaRepository.saveAndFlush(raw);

        return newEntity;
    }

    /**
     * <h2>createEntity</h2>
     * <p>Overridable method that save entities. Used by create and createAll methods that wrapped by @Transactional</p>
     *
     * @param raw
     *
     * @return
     */
    protected E createEntity(E raw) {
        return this.jpaRepository.saveAndFlush(raw);
    }

    @Override
    public E readById(ID id) {
        return this.jpaRepository.findById(id)
            .orElseThrow(
                () -> new ApiException(
                    format("Impossible to find entity %s with id %s", clazz.getSimpleName(), id),
                    HttpStatus.NOT_FOUND)
            );
    }

    @Override
    public List<E> readAll() {
        return this.jpaRepository.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public E update(E newEntity) {
        var updatedEntity = jpaRepository.saveAndFlush(newEntity);

        return updatedEntity;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public E deleteById(ID id) {
        var removableEntity = this.readById(id);
        this.jpaRepository.deleteById(id);

        return removableEntity;
    }

    @Override
    public boolean existsById(ID id) {
        return id != null && this.jpaRepository.existsById(id);
    }

}
