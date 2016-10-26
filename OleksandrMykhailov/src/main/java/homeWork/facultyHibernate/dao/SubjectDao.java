package homeWork.facultyHibernate.dao;

import homeWork.facultyHibernate.model.Subject;
//import exceptions.EntityNotFoundException;

import java.util.List;

public interface SubjectDao {

	List<Subject> getHumanitarSubjects(); // throws EntityNotFoundException;

}
