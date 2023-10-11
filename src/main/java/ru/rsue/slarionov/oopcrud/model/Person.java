package ru.rsue.slarionov.oopcrud.model;

public abstract class Person extends IdentifiedEntity {
    protected String lastName;
    protected String firstName;

    protected Person(long id, String lastName, String firstName) {
        super(id);
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
