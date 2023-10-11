package ru.rsue.slarionov.oopcrud.model;

public class Student extends Person {
    private int performance;

    public Student(long id, String lastName, String firstName, int performance) {
        super(id, lastName, firstName);
        this.performance = performance;
    }

    public static Student fromString(String string) {
        String[] attributes = string.split(", ");
        return new Student(
            Long.parseLong(attributes[0]),
            attributes[1],
            attributes[2],
            Integer.parseInt(attributes[3])
        );
    }

    @Override
    public String toString() {
        return String.format(
            "Student{id=%d, lastName='%s', firstName='%s', performance=%d}",
            id, lastName, firstName, performance
        );
    }
}
