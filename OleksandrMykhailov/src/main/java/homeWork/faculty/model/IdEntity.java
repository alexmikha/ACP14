package homeWork.faculty.model;

/**
 * Created by mi on 13.10.2016.
 */

public class IdEntity {


    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdEntity idEntity = (IdEntity) o;

        return id == idEntity.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}

