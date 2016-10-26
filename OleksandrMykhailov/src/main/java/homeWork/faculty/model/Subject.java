package homeWork.faculty.model;

import java.util.List;

/**
 * Created by mi on 05.10.2016.
 */

public class Subject extends IdEntity {


    private String subjectName;
    private String description;

    public Subject(String subjectName, String description) {
        this.subjectName = subjectName;
        this.description = description;
    }

    public Subject() {

    }

    private Teacher teacher;
    private List<Group> groupList;
    private Student student;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
