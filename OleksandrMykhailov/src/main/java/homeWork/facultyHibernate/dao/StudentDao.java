package homeWork.facultyHibernate.dao;

import homeWork.facultyHibernate.model.Group;
import homeWork.facultyHibernate.model.Student;
//import exceptions.EntityNotFoundException;

import java.util.List;

public interface StudentDao  {

	List<Student> getListOfStudentsInGroup(Group group); //throws EntityNotFoundException;
}
