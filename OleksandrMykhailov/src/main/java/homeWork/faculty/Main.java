package homeWork.faculty;

import homeWork.faculty.utilsDao.ManagementFaculty;
import homeWork.faculty.view.MenuDao;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by mi on 06.10.2016.
 */
public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        ManagementFaculty faculty = new ManagementFaculty();
  //      Scanner sc = new Scanner(System.in);
//        System.out.println(faculty.getStudents());
//        System.out.println(faculty.getGroup());
//        System.out.println(faculty.getTeacher());
//        System.out.println(faculty.getSubject());
//
//
//        System.out.println(faculty.addStudentToDao());
//        System.out.println(faculty.getStudents());
//        System.out.println(faculty.addTeachertToDao());

MenuDao menuDao = new MenuDao();
        menuDao.menu();
    }
}
