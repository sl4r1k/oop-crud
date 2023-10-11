package ru.rsue.slarionov.oopcrud.repository;

import ru.rsue.slarionov.oopcrud.model.Person;
import java.util.Collections;
import java.util.List;

public abstract class PersonRepository<T extends Person> implements Repository<T> {
    @Override
    public T create(T person) {
        getDatasource().add(person);
        return person;
    }

    @Override
    public T getById(long id) {
        return getDatasource().stream()
            .filter(student -> student.getId() == id)
            .findFirst()
            .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<T> getAll() {
        return Collections.unmodifiableList(getDatasource());
    }

    @Override
    public void deleteById(long id) {
        getDatasource().removeIf(person -> person.getId() == id);
    }

    protected abstract List<T> getDatasource();
}
