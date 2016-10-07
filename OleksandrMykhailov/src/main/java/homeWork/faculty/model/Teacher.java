package homeWork.faculty.model;

/**
 * Created by mi on 05.10.2016.
 */
public class Teacher {

    private int id;
    private String teacherName;
    private int experience;
    private int subject_id;

    public Teacher(int id, String teacherName, int experience, int subject_id) {
        this.id = id;
        this.teacherName = teacherName;
        this.experience = experience;
        this.subject_id = subject_id;
    }

    public Teacher() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getExperience() {

        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
