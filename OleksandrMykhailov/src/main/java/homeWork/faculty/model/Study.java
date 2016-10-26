package homeWork.faculty.model;

import java.util.List;

/**
 * Created by mi on 12.10.2016.
 */

public class Study extends IdEntity{


    private int groupId;

    private int subjectId;

    public Study() {
    }


    private List<Integer> subId ; //= new ArrayList<>();

//    public Study() {
//        this.subjectsId = new ArrayList<>();
//    }


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public List<Integer> getSubId() {
        return subId;
    }

    public void setSubId(List<Integer> subId) {
        this.subId = subId;
    }


    public boolean addSubject(Integer subject){
        subId.add(subject);
        return true;
    }
}
