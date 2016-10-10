package homeWork.faculty.model;

/**
 * Created by mi on 05.10.2016.
 */
public class Teacher {

    private int id;
    private String teacherName;
    private int experience;
    private int subjectId;

    public Teacher(int id, String teacherName, int experience, int subjectId) {
        this.id = id;
        this.teacherName = teacherName;
        this.experience = experience;
        this.subjectId = subjectId;
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

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherName='" + teacherName + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}
