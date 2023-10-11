package ru.rsue.slarionov.oopcrud.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ru.rsue.slarionov.oopcrud.Db;
import ru.rsue.slarionov.oopcrud.model.Lesson;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LessonRepository implements Repository<Lesson> {
    @Override
    public Lesson create(Lesson lesson) {
        Db.LESSONS.add(lesson);
        return lesson;
    }

    @Override
    public Lesson getById(long id) {
        return Db.LESSONS.stream()
            .filter(lesson -> lesson.getId() == id)
            .findFirst()
            .orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Lesson> getAll() {
        return Collections.unmodifiableList(Db.LESSONS);
    }

    @Override
    public void deleteById(long id) {
        throw new UnsupportedOperationException();
    }

    public List<Lesson> loadFromJsonFile(File file) {
        List<Lesson> lessons;
        try (FileReader reader = new FileReader(file)) {
            lessons = new Gson().fromJson(reader, new TypeToken<ArrayList<Lesson>>() {}.getType());
            Db.LESSONS.addAll(lessons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lessons;
    }
}
