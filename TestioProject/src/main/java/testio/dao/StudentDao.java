package testio.dao;

import testio.model.Student;

import java.util.List;

/**
 * Created by Mi on 27.10.16.
 */
public interface StudentDao {


    Student create(Student student);

    Student remove(int id);

    Student find(String login);

    Student find(int id);

    List<Student> getAll(int start, int end);


}
