package homeWork.faculty.utilsDao;

import homeWork.faculty.model.Group;
import homeWork.faculty.model.Student;
import homeWork.faculty.model.Subject;
import homeWork.faculty.model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mi on 05.10.2016.
 */
public class ManagementFaculty {

    public static final String UR = "jdbc:mysql://localhost:3306/FACULTY";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public Connection connection;
    Statement statement;
    PreparedStatement prstmt;
    ResultSet resultSet;

    private static ManagementFaculty instance;
//    Collection<Student> students = new ArrayList<>();
//    Collection<Group> group = new ArrayList<>();

    public ManagementFaculty() throws ClassNotFoundException, SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("OK: Connect the driver");
            connection = DriverManager.getConnection(UR, USER, PASSWORD);
            System.out.println("OK: connect to the database");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("ERROR");

        }
    }

    public static synchronized ManagementFaculty getInstance() throws SQLException, ClassNotFoundException {

        if (instance == null) {
            instance = new ManagementFaculty();
        }
        return instance;
    }

    public List<Student> getStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String studentsQuery = "SELECT id, studentName, avg_score, group_id FROM students";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(studentsQuery);
            while (resultSet.next()) {
                Student student = new Student(resultSet);
//                student.setId(resultSet.getInt(1));
//                student.setStudentName(resultSet.getString(2));
//                student.setAvg_score(resultSet.getDouble(3));
//                student.setGroup_id(resultSet.getInt(4));
                students.add(student);
            }
        } finally {
            ConnectionClose.closeResultSet(resultSet);
            ConnectionClose.closeStatement(statement);
        }
        return students;
    }


    public List<Group> getGroup() throws SQLException {
        List<Group> groups = new ArrayList<>();
        String groupQuery = "SELECT id, groupName FROM groups";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(groupQuery);
            while (resultSet.next()) {
                Group gr = new Group();
                gr.setId(resultSet.getInt(1));
                gr.setGroupName(resultSet.getString(2));
                groups.add(gr);
            }
        } finally {
            ConnectionClose.closeResultSet(resultSet);
            ConnectionClose.closeStatement(statement);
        }
        return groups;
    }

    public List<Teacher> getTeacher() throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        String teacherQuery = "SELECT id, teacherName, experience, subject_id FROM teachers";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(teacherQuery);
            while (resultSet.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(resultSet.getInt(1));
                teacher.setTeacherName(resultSet.getString(2));
                teacher.setExperience(resultSet.getInt(3));
                teacher.setSubject_id(resultSet.getInt(4));
                teachers.add(teacher);
            }
        } finally {
            ConnectionClose.closeResultSet(resultSet);
            ConnectionClose.closeStatement(statement);
        }
        return teachers;
    }

    public List<Subject> getSubject() throws SQLException {
        List<Subject> subjects = new ArrayList<>();
        String subjectQuery = "SELECT id, subjectName, description  FROM subjects";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(subjectQuery);
            while (resultSet.next()) {
                Subject subject = new Subject();
                subject.setId(resultSet.getInt(1));
                subject.getSubjectName();
                subject.setDescription(resultSet.getString(3));
                subjects.add(subject);
            }
        } finally {
            ConnectionClose.closeResultSet(resultSet);
            ConnectionClose.closeStatement(statement);
        }
        return subjects;
    }

    @SuppressWarnings("JpaQueryApiInspection")
    public void addStudentToDao(Student student) throws SQLException {
        PreparedStatement prstmt = null;
        String addStudent = "INSERT INTO students(studentName, avg_score, group_id) VALUE (?,?,?)";
        try {
            prstmt = connection.prepareStatement(addStudent);
            prstmt.setString(1, student.getStudentName());
            prstmt.setDouble(2, student.getAvg_score());
            prstmt.setInt(3, student.getGroup_id());
            prstmt.execute();

        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
    }

    @SuppressWarnings("JpaQueryApiInspection")
    public boolean addTeachertToDao() throws SQLException {
        Teacher teacher = new Teacher(1, "Shpak", 20, 2);
        PreparedStatement prstmt = null;
        try {
            prstmt = connection.prepareStatement(
                    "INSERT INTO teachers(teacherName, experience, subject_id) VALUE (?, ?, ?)");
            prstmt.setString(1, teacher.getTeacherName());
            prstmt.setInt(2, teacher.getExperience());
            prstmt.setInt(3, teacher.getSubject_id());
            prstmt.execute();
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        return true;
    }

    @SuppressWarnings("JpaQueryApiInspection")
    public boolean addSubjectToDao() throws SQLException {
        Subject subject = new Subject(1, "philosophy", "study philosophy");
        PreparedStatement prstmt = null;
        try {
            prstmt = connection.prepareStatement(
                    "INSERT INTO subjects(subjectName, description) VALUE (?, ?)");
            prstmt.setString(1, subject.getSubjectName());
            prstmt.setString(2, subject.getDescription());
            prstmt.execute();

        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        return true;
    }

    @SuppressWarnings("JpaQueryApiInspection")
    public boolean addGroupToDao() throws SQLException {
        Group group = new Group(1, "fourth");
        PreparedStatement prstmt = null;
        try {
            prstmt = connection.prepareStatement(
                    "INSERT INTO groups(groupName) VALUE (?)");
            prstmt.setString(1, group.getGroupName());
            prstmt.execute();
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
        return true;
    }

    public List<Teacher> getTeacherMinExperience() throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        String minQuery = "SELECT teacherName, MIN(experience) FROM teachers";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(minQuery);
            while (resultSet.next()) {
                Teacher teacherMin = new Teacher();
                teacherMin.setTeacherName(resultSet.getString(1));
                teacherMin.setExperience(resultSet.getInt(2));
                teachers.add(teacherMin);
            }
        } finally {
            ConnectionClose.closeResultSet(resultSet);
            ConnectionClose.closeStatement(statement);
        }
        return teachers;
    }

    public List<Teacher> getTeacherMaxExperience() throws SQLException {
        List<Teacher> teachers = new ArrayList<>();
        String maxQuery = "SELECT teacherName, MAX(experience) FROM teachers";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(maxQuery);
            while (resultSet.next()) {
                Teacher teacherMax = new Teacher();
                teacherMax.setTeacherName(resultSet.getString(1));
                teacherMax.setExperience(resultSet.getInt(2));
                teachers.add(teacherMax);
            }
        } finally {
            ConnectionClose.closeResultSet(resultSet);
            ConnectionClose.closeStatement(statement);
        }
        return teachers;
    }

    public void deleteStudent(Student student) throws SQLException {
        PreparedStatement prstmt = null;
        try {
            prstmt = connection.prepareStatement(
                    "DELETE FROM students WHERE id=?");
            prstmt.setInt(1, student.getId());
            prstmt.execute();
        } finally {
            ConnectionClose.closePreparedStatement(prstmt);
        }
    }
}



