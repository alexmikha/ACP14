package homeWork.faculty.view;

import homeWork.faculty.model.Student;
import homeWork.faculty.service.ManagerSevice;
import homeWork.faculty.utilsDao.ManagerConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mi on 07.10.2016.
 */
public class MenuDao {
    //   public static final Logger logger = Logger.getLogger(String.valueOf(MenuDao.class));
  //  private ManagementFaculty faculty = new ManagementFaculty();
   // private StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
    private ManagerConnection managerConnection = new ManagerConnection();
    private ManagerSevice managerSevice = new ManagerSevice();
    private BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    int id;
    private String studentName;
    private double avg;
    private int group_id;

    public MenuDao() throws SQLException, ClassNotFoundException {

    }

    public int menu() throws IOException, SQLException, ClassNotFoundException {
        Student student = new Student(studentName, group_id );
        System.out.println();
        System.out.println("Select:");
        System.out.println(1 + " Get a list of all students");
        System.out.println(2 + " Get a list of groups");
        System.out.println(3 + " Get a list of teachers");
        System.out.println(4 + " Get a list of subjects");
        System.out.println(5 + " Add a student in DB");
        System.out.println(6 + " Add a group in DB");
        System.out.println(7 + " Add a teacher in DB");
        System.out.println(8 + " Add a subject in DB");
        System.out.println(9 + " Get a list of teachers min experience");
        System.out.println(10 + " Get a list of teachers max experience");
        System.out.println(11 + " Delete student from DB");
        System.out.println(12 + " Update student from DB");
        System.out.println(13 + " ");
        System.out.println(14 + " ");
        System.out.println(15 + " ");

        String menu = bf.readLine();
        switch (menu) {
            case "1":
                for (int i = 0; i < managerSevice.getAllStudents().size(); i++) {
                    System.out.println(managerSevice.getAllStudents().get(i));
                }
                break;
            case "2":
                for (int i = 0; i <  managerSevice.getAllGroup().size(); i++) {
                    System.out.println(managerSevice.getAllGroup().get(i));
                }
                break;
            case "3":
                for (int i = 0; i < managerSevice.getAllTeacher().size(); i++) {
                    System.out.println(managerSevice.getAllTeacher().get(i));
                }

                break;
            case "4":
//                for (int i = 0; i < managerSevice.getAllSubject.size(); i++) {
//                    System.out.println(managerSevice.getAllSubject.get(i));
//                }
                break;
            case "5":
                System.out.println("Enter studentName");
                studentName = bf.readLine();
                student.setStudentName(studentName);

                System.out.println("Enter avgScore");
                avg = Double.parseDouble(bf.readLine());
         //       student.setAvgScore(avg);

                System.out.println("Enter group");
                group_id = Integer.parseInt(bf.readLine());
                student.setGroupId(group_id);

                managerSevice.createStudent(student);
                System.out.println("Student " + studentName + " was added in DB");

                break;
            case "6":
              //  System.out.println(managerSevice.createTeacher());
                break;
            case "7":
//                System.out.println(faculty.addSubjectToDB());
                break;
            case "8":
//                System.out.println(faculty.addGroupToDB());
                break;
            case "9":
//                for (int i = 0; i < faculty.getTeacherMinExperience().size(); i++) {
//                    System.out.println("min expiriance is " + faculty.getTeacherMinExperience().get(i));
//                }
                break;
            case "10":
//                for (int i = 0; i < faculty.getTeacherMinExperience().size(); i++) {
//                    System.out.println("max experience is " + faculty.getTeacherMaxExperience().get(i));
//                }
                break;
            case "11":
                System.out.println("Enter id for delete the student");
                id = Integer.parseInt(bf.readLine());
                student.setId(id);
                managerSevice.deleteStudent(student);
                System.out.println("Student " + studentName + " was deleted from DB");
                break;
            case "12":
                List<Student> studentList = managerSevice.getAllStudents();

                System.out.println("Enter studentName");
                studentName = bf.readLine();
                student.setStudentName(studentName);

                System.out.println("Enter avgScore");
                avg = Double.parseDouble(bf.readLine());
       //         student.setAvgScore(avg);

                System.out.println("Enter group_id");
                group_id = Integer.parseInt(bf.readLine());
                student.setGroupId(group_id);

                System.out.println("Enter id");
                id = Integer.parseInt(bf.readLine());
                student.setId(id);
                managerSevice.updateStudent(student);
                System.out.println("Student " + studentName + " was updated in DB");
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
//                managerConnection.connection.commit();
//                ManagementFaculty.getInstance();
                break;
            case "2":
          //      faculty.connection.setAutoCommit(false);
                exitFromMenu();
                break;
        }
        return 0;
    }

    private void exitFromMenu() throws IOException, SQLException {
        bf.close();
      //  faculty.connection.close();
    }

}