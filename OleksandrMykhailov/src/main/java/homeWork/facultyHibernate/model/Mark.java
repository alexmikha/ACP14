package homeWork.facultyHibernate.model;

import javax.persistence.*;

/**
 * Created by mi on 18.10.2016.
 */
@Entity
@Table(name = "marks")
public class Mark extends IdEntity{

    @Column(name = "mark",length = 20)
    private int mark;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    public Mark() {
    }

    public Mark(int mark, Student student, Subject subject) {
        this.mark = mark;
        this.student = student;
        this.subject = subject;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}
