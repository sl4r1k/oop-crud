package ru.rsue.slarionov.oopcrud.model;

public class Teacher extends Person {
    private String subject;

    public Teacher(long id, String lastName, String firstName, String subject) {
        super(id, lastName, firstName);
        this.subject = subject;
    }

    public static Teacher fromString(String string) {
        String[] attributes = string.split(", ");
        return new Teacher(
            Long.parseLong(attributes[0]),
            attributes[1],
            attributes[2],
            attributes[3]
        );
    }

    @Override
    public String toString() {
        return String.format(
            "Teacher{id=%d, lastName='%s', firstName='%s', subject=%s}",
            id, lastName, firstName, subject
        );
    }
}
