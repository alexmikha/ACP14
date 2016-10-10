package homeWork.faculty.model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mi on 05.10.2016.
 */
public class Student {

    private int id;
    private String studentName;
    private double avgScore;
    private int groupId;

    public Student(String studentName, double avgScore, int groupId) {
 //       this.id = id;
        this.studentName = studentName;
        this.avgScore = avgScore;
        this.groupId = groupId;
    }

    public Student(ResultSet rs) throws SQLException {
        setId(rs.getInt(1));
        setStudentName(rs.getString(2));
        setAvgScore(rs.getDouble(3));
        setGroupId(rs.getInt(4));
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

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
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
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", avg_score=" + avgScore +
                ", group_id=" + groupId +
                '}';
    }
}
