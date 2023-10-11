package ru.rsue.slarionov.oopcrud.model;

import java.util.Objects;

public abstract class IdentifiedEntity {
    protected final long id;

    protected IdentifiedEntity(long id) {
        this.id = id;
    }

    public long getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof IdentifiedEntity)) {
            return false;
        }
        IdentifiedEntity entity = (IdentifiedEntity) object;
        return this.id == entity.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
