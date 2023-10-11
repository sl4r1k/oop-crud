package ru.rsue.slarionov.oopcrud.repository;

import ru.rsue.slarionov.oopcrud.model.IdentifiedEntity;
import java.util.List;

public interface Repository<T extends IdentifiedEntity>  {
    T create(T entity);

    T getById(long id);

    List<T> getAll();

    void deleteById(long id);
}
