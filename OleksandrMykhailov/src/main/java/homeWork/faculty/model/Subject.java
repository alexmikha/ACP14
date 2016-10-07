package homeWork.faculty.model;

/**
 * Created by mi on 05.10.2016.
 */
public class Subject {

    private int id;
    private  String subjectName;
    private String description;

    public Subject(int id, String subjectName, String description) {
        this.id = id;
        this.subjectName = subjectName;
        this.description = description;
    }

    public Subject() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
