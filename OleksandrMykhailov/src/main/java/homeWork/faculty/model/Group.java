package homeWork.faculty.model;

/**
 * Created by mi on 05.10.2016.
 */
public class Group {

    private int id;
    private String groupName;

    public Group(int id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public Group() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupName='" + groupName + '\'' +
                '}';
    }
}
