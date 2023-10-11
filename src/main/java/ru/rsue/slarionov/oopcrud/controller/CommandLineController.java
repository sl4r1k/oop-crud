package ru.rsue.slarionov.oopcrud.controller;

import ru.rsue.slarionov.oopcrud.model.Lesson;
import ru.rsue.slarionov.oopcrud.model.Student;
import ru.rsue.slarionov.oopcrud.model.Teacher;
import ru.rsue.slarionov.oopcrud.repository.LessonRepository;
import ru.rsue.slarionov.oopcrud.repository.Repository;
import ru.rsue.slarionov.oopcrud.repository.StudentRepository;
import ru.rsue.slarionov.oopcrud.repository.TeacherRepository;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CommandLineController {
    private final Scanner scanner = new Scanner(System.in);
    private final Repository<Student> studentRepository = new StudentRepository();
    private final Repository<Teacher> teacherRepository = new TeacherRepository();
    private final LessonRepository lessonRepository = new LessonRepository();
    private final Map<Integer, Supplier<String>> commands = Map.ofEntries(
        Map.entry(1, () -> {
            System.out.println("Введите значения полей студента через запятую");
            return studentRepository.create(Student.fromString(scanner.nextLine())).toString();
        }),
        Map.entry(2, () -> {
            System.out.println("Введите id студента");
            return studentRepository.getById(Long.parseLong(scanner.nextLine())).toString();
        }),
        Map.entry(3, () -> {
            return studentRepository.getAll()
                .stream()
                .map(Student::toString)
                .collect(Collectors.joining("\n"));
        }),
        Map.entry(4, () -> {
            System.out.println("Введите id студента");
            studentRepository.deleteById(Long.parseLong(scanner.nextLine()));
            return "OK";
        }),
        Map.entry(5, () -> {
            System.out.println("Введите значения полей учителя через запятую");
            return teacherRepository.create(Teacher.fromString(scanner.nextLine())).toString();
        }),
        Map.entry(6, () -> {
            System.out.println("Введите id учителя");
            return teacherRepository.getById(Long.parseLong(scanner.nextLine())).toString();
        }),
        Map.entry(7, () -> {
            return teacherRepository.getAll()
                .stream()
                .map(Teacher::toString)
                .collect(Collectors.joining("\n"));
        }),
        Map.entry(8, () -> {
            System.out.println("Введите id учителя");
            teacherRepository.deleteById(Long.parseLong(scanner.nextLine()));
            return "OK";
        }),
        Map.entry(9, () -> {
            System.out.println("Введите значения полей занятия через запятую");
            return lessonRepository.create(Lesson.fromString(scanner.nextLine())).toString();
        }),
        Map.entry(10, () -> {
            System.out.println("Введите id занятия");
            return lessonRepository.getById(Long.parseLong(scanner.nextLine())).toString();
        }),
        Map.entry(11, () -> {
            return lessonRepository.getAll()
                .stream()
                .map(Lesson::toString)
                .collect(Collectors.joining("\n"));
        }),
        Map.entry(12, () -> {
            System.out.println("Введите путь к файлу");
            return lessonRepository.loadFromJsonFile(
                    Paths.get(scanner.nextLine())
                        .toFile()
                ).stream()
                .map(Lesson::toString)
                .collect(Collectors.joining("\n"));
        })
    );

    public void accept(String command) {
        System.out.println(
            commands.get(Integer.parseInt(command))
                .get()
        );
    }
}
