package homeWork.facultyHibernate.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mi on 05.10.2016.
 */
@Entity
@Table(name = "subjects")
@NamedQuery(name = "Subject.getAll", query = "SELECT sb FROM Subject sb")
public class Subject extends IdEntity {

    @Column(name = "name", length = 20)
    private String subjectName;

    @Column(name = "description", length = 20)
    private String description;

    @ManyToMany(mappedBy = "subjectSet", cascade = CascadeType.ALL)
    private Set<Group> groupSet= new HashSet<>();

    @OneToMany(mappedBy = "subject")
    private List<Mark> markList;

    @OneToOne(mappedBy = "subject")
    private Teacher teacher;

    public Subject(String subjectName, String description) {
        this.subjectName = subjectName;
        this.description = description;

    }

    public Subject() {

    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    public Set<Group> getGroupSet() {
        return groupSet;
    }

    public void setGroupSet(Set<Group> groupSet) {
        this.groupSet = groupSet;
    }

    public List<Mark> getMarkList() {
        return markList;
    }

    public void setMarkList(List<Mark> markList) {
        this.markList = markList;
    }

    public void addGroup(Group group){
        groupSet.add(group);
    }

    public void addMark(Mark mark) {
        this.markList.add(mark);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Subject subject = (Subject) o;

        if (subjectName != null ? !subjectName.equals(subject.subjectName) : subject.subjectName != null) return false;
        return description != null ? !description.equals(subject.description) : subject.description != null ;
//        if (teacher != null ? !teacher.equals(subject.teacher) : subject.teacher != null) return false;
//        return groupSet != null ? groupSet.equals(subject.groupSet) : subject.groupSet == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (subjectName != null ? subjectName.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
//        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
  //      result = 31 * result + (groupSet != null ? groupSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + getId() +
                ", subjectName='" + subjectName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }



}
