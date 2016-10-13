package homeWork.faculty.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mi on 05.10.2016.
 */
@Entity
@Table(name = "students")
public class Student extends week6.jpa.model.IdEntity{
    @Column(nullable = false)
    private String studentName;
    @Column
    private double avgScore;
    @Column
    private int groupId;

    public Student(String studentName, double avgScore, int groupId) {
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

    public Student() {

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
                "id=" + getId() +
                ", studentName='" + studentName + '\'' +
                ", avgScore=" + avgScore +
                ", group_id=" + groupId +
                '}';
    }
}
