package homeWork.faculty.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by mi on 05.10.2016.
 */
@Entity
@Table(name = "groups")
public class Group extends IdEntity {

    @Column(nullable = false)
    private String groupName;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group() {

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
                "id=" + getId() +
                "groupName='" + groupName + '\'' +
                '}';
    }
}
