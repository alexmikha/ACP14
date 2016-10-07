package homeWork.faculty.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mi on 05.10.2016.
 */
public class Student {

    private int id;
    private String studentName;
    private double avg_score;
    private int group_id;

    public Student(String studentName, double avg_score, int group_id) {
        this.id = id;
        this.studentName = studentName;
        this.avg_score = avg_score;
        this.group_id = group_id;
    }


    public Student() {

    }

    public Student(ResultSet rs) throws SQLException {
        setId(rs.getInt(1));
        setStudentName(rs.getString(2));
        setAvg_score(rs.getDouble(3));
        setGroup_id(rs.getInt(4));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getAvg_score() {
        return avg_score;
    }

    public void setAvg_score(double avg_score) {
        this.avg_score = avg_score;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", avg_score=" + avg_score +
                ", group_id=" + group_id +
                '}';
    }
}
