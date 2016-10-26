package homeWork.faculty.dao;

import homeWork.faculty.controller.ControllerDao;
import homeWork.faculty.model.Study;
import homeWork.faculty.utilsDao.ManagerConnection;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mi on 10.10.2016.
 */
public class StudyDaoImpl implements ControllerDao<Study, Integer> {

    private static final Logger logger = Logger.getLogger(GroupDaoImpl.class);
    private PreparedStatement prstmt;
    private Connection connection = ManagerConnection.getConnection();
    private Statement statement;
    private ResultSet resultSet;

    public StudyDaoImpl() throws SQLException {
    }

    @Override
    public List<Study> getAll() throws SQLException {
        logger.info("Calling method getAllStudy");
        connection = ManagerConnection.getConnection();
        List<Study> studyList = new ArrayList<>();
        Set<Integer> groupsSet = new HashSet<>();
        String query = "SELECT groups.id group_id, subjects.id subject_id FROM groups LEFT JOIN study ON" +
                " groups.id=study.group_id LEFT JOIN subjects ON study.subject_id=subjects.id;";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Integer groupId = resultSet.getInt("group_id");
                Integer subjectId = resultSet.getInt("subject_id");
                if (groupId != null && subjectId != null) {
                    if (!groupsSet.contains(groupId)) {
                        Study study = new Study();
                        study.setId(groupId);
                        study.addSubject(subjectId);
                        studyList.add(study);
                        groupsSet.add(study.getId());
                    } else {
                        Study study = findStudyById(studyList, groupId);
                        study.addSubject(subjectId);
                    }
                }
            }
            return studyList;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean insertEntity(Study study) throws SQLException {
        logger.info("Calling  method addStudyToDB create new study");
        return updateEntity(study);
    }

    @Override
    public boolean deleteEntity(Study study) throws SQLException {
        return updateEntity(study);
    }

    @Override
    public boolean updateEntity(Study study) throws SQLException {
        logger.info("Calling  method updateStudy");
        String delSqlQuery = "DELETE FROM study WHERE group_id=?;";
        String addSqlQuery = "INSERT INTO study (group_id, subject_id) VALUES (?,?)";

        try {PreparedStatement prstmtDel = connection.prepareStatement(delSqlQuery);
             PreparedStatement prstmtAdd = connection.prepareStatement(addSqlQuery);
            prstmtDel.setInt(1, study.getId());
            prstmtDel.execute();

            for(Integer integer : study.getSubId()) {
                prstmtAdd.setInt(1, study.getId());
                prstmtAdd.setInt(2, integer);
                prstmtAdd.execute();
            }
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("not connection " + e.getMessage());
            return false;
        }
    }

    @Override
    public Study getEntityById(Integer id) {
        return null;
    }

    private static Study findStudyById(List<Study> studies, int id) {
        logger.info("Calling  method findStudyById");
        for (Study study : studies) {
            if(study.getId()==id) {
                return study;
            }
        }
        return null;
    }
}
