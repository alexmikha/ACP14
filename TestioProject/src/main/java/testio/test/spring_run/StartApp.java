package testio.test.spring_run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import testio.exception.NoStudentFoundException;
import testio.model.Student;
import testio.model.StudentType;
import testio.service.RegisterException;
import testio.service.StudentService;

import java.util.Date;
import java.util.List;

/**
 * Created by Mi on 27.10.16.
 */
public class StartApp {


    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("/spring-context.xml");

        StudentService studentService = context.getBean(StudentService.class);


        try {
            Student student = studentService.getStudentInfo(2);
            studentService.register(new Student("Bogdan", 5, StudentType.SENIOR, new Date(), "234"));

            List<Student> studentList = studentService.getAll(0,100);
            studentList.stream().forEach(System.out::println);
        } catch (NoStudentFoundException e) {
            e.printStackTrace();
        } catch (RegisterException e) {
            e.printStackTrace();
        }
    }
}
