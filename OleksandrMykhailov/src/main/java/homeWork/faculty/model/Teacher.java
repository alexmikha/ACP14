package homeWork.faculty.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mi on 05.10.2016.
 */

public class Teacher extends IdEntity {


    private String teacherName;
    private int exper;
    private int subjectId;

    private Subject subject;


    public Teacher(String teacherName, int exper, int subjectId) {
        this.teacherName = teacherName;
        this.exper = exper;
        this.subjectId = subjectId;
    }

    public Teacher() {

    }

    public Teacher(ResultSet rs) throws SQLException {
        setId(rs.getInt(1));
        setTeacherName(rs.getString(2));
        setExper(rs.getInt(3));
        setSubjectId(rs.getInt(4));
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public int getExper() {
        return exper;
    }

    public void setExper(int exper) {
        this.exper = exper;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                "teacherName='" + teacherName + '\'' +
                ", experience=" + exper +
                ", subjectId=" + subjectId +
                '}';
    }

}
