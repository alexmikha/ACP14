package homeWork.faculty.model;

import javax.persistence.Column;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mi on 05.10.2016.
 */
public class Teacher extends IdEntity{

   @Column(nullable = false)
    private String teacherName;
    @Column(nullable = false)
    private int experience;
    @Column
    private int subjectId;

    public Teacher( String teacherName, int experience, int subjectId) {
        this.teacherName = teacherName;
        this.experience = experience;
        this.subjectId = subjectId;
    }

    public Teacher() {

    }

    public Teacher(ResultSet rs) throws SQLException {
        setId(rs.getInt(1));
        setTeacherName(rs.getString(2));
        setExperience(rs.getInt(3));
        setSubjectId(rs.getInt(4));
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
                "id=" + getId() +
                "teacherName='" + teacherName + '\'' +
                ", experience=" + experience +
                ", subjectId=" + subjectId +
                '}';
    }
}
