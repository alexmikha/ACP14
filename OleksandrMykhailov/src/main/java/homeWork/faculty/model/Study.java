package homeWork.faculty.model;

/**
 * Created by mi on 10.10.2016.
 */
public class Study {
    private int groupId;
    private int subjectId;

    public Study(int groupId, int subjectId) {
        this.groupId = groupId;
        this.subjectId = subjectId;
    }

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

    @Override
    public String toString() {
        return "Study{" +
                "groupId=" + groupId +
                ", subjectId=" + subjectId +
                '}';
    }
}
