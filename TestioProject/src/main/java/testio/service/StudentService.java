package testio.service;

import testio.exception.NoStudentFoundException;
import testio.model.Student;

import java.util.List;

/**
 * Created by Mi on 27.10.16.
 */
public interface StudentService {


    Student login(String login) throws NoStudentFoundException;

    Student getStudentInfo(int id) throws NoStudentFoundException;

    Student register(Student newStudent) throws RegisterException;

    List<Student> getAll(int start, int lenght);

}
