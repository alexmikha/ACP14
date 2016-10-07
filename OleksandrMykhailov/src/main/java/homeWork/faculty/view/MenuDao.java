package homeWork.faculty.view;

import homeWork.faculty.model.Student;
import homeWork.faculty.utilsDao.ManagementFaculty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

/**
 * Created by mi on 07.10.2016.
 */
public class MenuDao {

    private ManagementFaculty faculty = new ManagementFaculty();

    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int id;
    private String studentName;
    private double avg;
    private int group_id;

    public MenuDao() throws SQLException, ClassNotFoundException {
    }

    public int menu() throws IOException, SQLException, ClassNotFoundException {
        Student student = new Student(studentName, avg, group_id);
        System.out.println();
        System.out.println("Select:");

        System.out.println(1 + " Get a list of all students");
        System.out.println(2 + " Get a list of groups");
        System.out.println(3 + " Get a list of teachers");
        System.out.println(4 + " Get a list of subjects");
        System.out.println(5 + " Add a student in DAO");
        System.out.println(6 + " Add a group in DAO");
        System.out.println(7 + " Add a teacher in DAO");
        System.out.println(8 + " Add a subject in DAO");
        System.out.println(9 + " Get a list of teachers min experience");
        System.out.println(10 + " Get a list of teachers max experience");
        System.out.println(11 + " Delete student from DAO");
        System.out.println(12 + " ");
        System.out.println(13 + " ");
        System.out.println(14 + " ");
        System.out.println(15 + " ");

        String menu = bf.readLine();
        switch (menu) {
            case "1":
                for (int i = 0; i < faculty.getStudents().size(); i++) {
                    System.out.println(faculty.getStudents().get(i));
                }
//                System.out.println(faculty.getStudents());
                break;
            case "2":
                for (int i = 0; i < faculty.getGroup().size(); i++) {
                    System.out.println(faculty.getGroup().get(i));
                }
                //  System.out.println(managementFaculty.getGroup().);
                break;
            case "3":
                for (int i = 0; i < faculty.getTeacher().size(); i++) {
                    System.out.println(faculty.getTeacher().get(i));
                }
//                System.out.println(faculty.getTeacher());
                break;
            case "4":
                for (int i = 0; i < faculty.getSubject().size(); i++) {
                    System.out.println(faculty.getSubject().get(i));
                }
//                System.out.println(faculty.getSubject());
                break;
            case "5":
                System.out.println("Enter studentName");
                studentName = bf.readLine();
                student.setStudentName(studentName);

                System.out.println("Enter avg_score");
                avg = Double.parseDouble(bf.readLine());
                student.setAvg_score(avg);

                System.out.println("Enter group_id");
                group_id = Integer.parseInt(bf.readLine());
                student.setGroup_id(group_id);

                faculty.addStudentToDao(student);
                System.out.println("Student was added in DB");

                break;
            case "6":
                System.out.println(faculty.addTeachertToDao());
                break;
            case "7":
                System.out.println(faculty.addSubjectToDao());
                break;
            case "8":
                System.out.println(faculty.addGroupToDao());
                break;
            case "9":
                for (int i = 0; i < faculty.getTeacherMinExperience().size(); i++) {
                    System.out.println("min expiriance is " + faculty.getTeacherMinExperience().get(i));
                }
//                System.out.println(faculty.getTeacherMinExpiriance());
                break;
            case "10":
                for (int i = 0; i < faculty.getTeacherMinExperience().size(); i++) {
                    System.out.println("max experience is " + faculty.getTeacherMaxExperience().get(i));
                }
                break;
            case "11":
                System.out.println("Enter id for delete the student");
                id = Integer.parseInt(bf.readLine());
                student.setId(id);
                faculty.deleteStudent(student);
                System.out.println("Student was deleted from DB");
                break;
            case "12":


                break;
            case "13":

                break;
            case "14":

                break;
            case "15":

                break;
        }
        return choiceMenu();
    }

    public int choiceMenu() throws IOException, SQLException, ClassNotFoundException {
        System.out.println();
        System.out.println("Select:");
        System.out.println(1 + " Enter in the menu ");
        System.out.println(2 + " Exit the application ");
        String choice = bf.readLine();
        switch (choice) {
            case "1":
                menu();
                faculty.connection.commit();
                ManagementFaculty.getInstance();
                break;
            case "2":
                faculty.connection.setAutoCommit(false);
                exitFromMenu();
                break;
        }
        return 0;
    }

    private void exitFromMenu() throws IOException, SQLException {
        bf.close();
        faculty.connection.close();
    }

}