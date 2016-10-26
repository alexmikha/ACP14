package homeWork.facultyHibernate.dao;

import homeWork.facultyHibernate.model.Group;
import homeWork.facultyHibernate.model.Subject;
//import homeWork.facultyHibernate.exceptions.EntityNotFoundException;

import java.util.List;

public interface GroupDao  {

	List<Group> getGroupsThatStudySubject(Subject subject);
}
