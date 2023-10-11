package ru.rsue.slarionov.oopcrud.model;

public class Lesson extends IdentifiedEntity {
    private String subject;
    private long teacherId;

    public Lesson(long id, String subject, long teacherId) {
        super(id);
        this.subject = subject;
        this.teacherId = teacherId;
    }

    public static Lesson fromString(String string) {
        String[] attributes = string.split(", ");
        return new Lesson(
            Long.parseLong(attributes[0]),
            attributes[1],
            Long.parseLong(attributes[2])
        );
    }

    @Override
    public String toString() {
        return String.format(
            "Lesson{id=%d, subject='%s', teacherId=%d}",
            id, subject, teacherId
        );
    }
}
