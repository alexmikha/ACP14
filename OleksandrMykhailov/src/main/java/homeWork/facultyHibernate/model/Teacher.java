package homeWork.facultyHibernate.model;

import javax.persistence.*;


/**
 * Created by mi on 05.10.2016.
 */
@Entity
@Table(name = "teachers")
@NamedQuery(name = "Teacher.getAll", query = "SELECT t FROM Teacher t")
public class Teacher extends IdEntity {

    @Column(name = "name", length = 20)
    private String teacherName;

    @Column(name = "experiance", length = 20)
    private int experience;

    @OneToOne(cascade = {CascadeType.PERSIST}) //{CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;


    public Teacher(String teacherName, int experience, Subject subject) {
        this.teacherName = teacherName;
        this.experience = experience;
        this.subject= subject;

    }

    public Teacher() {

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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {

        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Teacher teacher = (Teacher) o;

        if (experience != teacher.experience) return false;
        if (teacherName != null ? !teacherName.equals(teacher.teacherName) : teacher.teacherName != null) return false;
        return subject != null ? subject.equals(teacher.subject) : teacher.subject == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + experience;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + getId() +
                ", teacherName='" + teacherName + '\'' +
                ", experience=" + experience +
                ", subject=" + subject +
                '}';
    }
}
