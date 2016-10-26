package homeWork.faculty.model;

/**
 * Created by mi on 05.10.2016.
 */

public class Student extends IdEntity {


    private String studentName;
    private int groupId;


    public Student(String studentName, int groupId) {
        this.studentName = studentName;
        this.groupId = groupId;
    }

    public Student() {

    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }



    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", studentName='" + studentName + '\'' +
                ", groupName='" + groupId + '\'' +
                '}';
    }
}
