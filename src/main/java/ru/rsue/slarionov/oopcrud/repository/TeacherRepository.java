package ru.rsue.slarionov.oopcrud.repository;

import ru.rsue.slarionov.oopcrud.Db;
import ru.rsue.slarionov.oopcrud.model.Teacher;
import java.util.List;

public class TeacherRepository extends PersonRepository<Teacher> {
    @Override
    protected List<Teacher> getDatasource() {
        return Db.TEACHERS;
    }
}
