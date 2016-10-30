package testio.dto;

import testio.model.StudentType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Mi on 27.10.16.
 */
@XmlRootElement(name = "student")
public class StudentDTO {


    private int id;
    private String name;
    private StudentType studentType;

    public StudentDTO() {
    }

    public StudentDTO(int id, String name, StudentType studentType) {
        this.id = id;
        this.name = name;
        this.studentType = studentType;
    }

    @XmlAttribute(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentType getStudentType() {
        return studentType;
    }

    public void setStudentType(StudentType studentType) {
        this.studentType = studentType;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentType=" + studentType +
                '}';
    }
}
