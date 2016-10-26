package homeWork.facultyHibernate.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mi on 05.10.2016.
 */
@Entity
@Table(name = "students")
@NamedQuery(name = "Student.getAll", query = "SELECT s FROM Student s")
public class Student extends IdEntity {

    @Column(name = "name", length = (20))
    private String studentName;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)// cascade = {CascadeType.ALL}
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    private Group group;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Mark> markList ;


    public Student(String studentName, Group group) {
        this.studentName = studentName;
        this.group = group;
    }

    public Student() {
    }


    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Student(String studentName) {
        this.studentName = studentName;
    }

    public List<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }
//    public void addMark(Mark mark) {
//        this.markList.add(mark);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (studentName != null ? !studentName.equals(student.studentName) : student.studentName != null) return false;
        return group != null ? group.equals(student.group) : student.group == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", studentName='" + studentName + '\'' +
                ", group=" + group +
                '}';
    }
}

