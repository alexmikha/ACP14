package homeWork.facultyHibernate.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mi on 05.10.2016.
 */
@Entity
@Table(name = "groups")
@NamedQuery(name = "Group.getAll", query = "SELECT g FROM Group g")

public class Group extends IdEntity {

    @Column(name = "name", length = 20)
    private String groupName;

    @OneToMany(mappedBy = "group",  fetch = FetchType.LAZY, cascade = CascadeType.ALL) //cascade = CascadeType.ALL
    private Set<Student> studentSet = new HashSet<>();

    @ManyToMany //(cascade = CascadeType.ALL)
    @JoinTable(name = "study",
            joinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    private Set<Subject> subjectSet = new HashSet<>();


    public Group() {

    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public Set<Subject> getSubjectSet() {
        return subjectSet;
    }

    public void setSubjectSet(Set<Subject> subjectSet) {
        this.subjectSet = subjectSet;
    }

    public void addStudent(Student student){
        this.studentSet.add(student);
    }

    public void addSubject(Subject subject){
        this.subjectSet.add(subject);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Group group = (Group) o;

        return groupName != null ? groupName.equals(group.groupName) : group.groupName == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + getId() +
                ", groupName='" + groupName + '\'' +
                '}';
    }
}
