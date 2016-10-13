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
@Table
public class Subject extends IdEntity{

    @Column(nullable = false)
    private  String subjectName;
    @Column
    private String description;

    public Subject(String subjectName, String description) {
        this.subjectName = subjectName;
        this.description = description;
    }

    public Subject() {

    }

    public Subject(ResultSet rs) throws SQLException {
        setId(rs.getInt(1));
        setSubjectName(rs.getString(2));
        setDescription(rs.getString(3));
    }

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

    @Override
    public String toString() {
        return "Subject{" +
                "subjectName='" + subjectName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
