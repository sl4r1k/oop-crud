package ru.rsue.slarionov.oopcrud.repository;

import ru.rsue.slarionov.oopcrud.Db;
import ru.rsue.slarionov.oopcrud.model.Student;
import java.util.List;

public class StudentRepository extends PersonRepository<Student> {
    @Override
    protected List<Student> getDatasource() {
        return Db.STUDENTS;
    }
}
