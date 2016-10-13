package homeWork.faculty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mi on 12.10.2016.
 */
@Entity
@Table(name = "study")
public class Study extends IdEntity{

    @Column(nullable = false)
    String studyName;

    public Study() {
    }

    private List<Integer> subjectsId;

//    public Study() {
//        this.subjectsId = new ArrayList<>();
//    }

    public List<Integer> getSubjects() {
        return subjectsId;
    }

    public void setSubjects(List<Integer> subjects) {

        this.subjectsId = subjects;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

    public boolean addSubject(Integer subject){
        subjectsId.add(subject);
        return true;
    }
}
