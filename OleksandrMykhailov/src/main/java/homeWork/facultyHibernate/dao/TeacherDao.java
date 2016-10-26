package homeWork.facultyHibernate.dao;

import homeWork.facultyHibernate.model.Teacher;


import java.util.List;

public interface TeacherDao  {

	List<Teacher> getMaxExperienceTeacher(); //throws EntityNotFoundException;

	List<Teacher> getLessExperienceTeacher(); //throws EntityNotFoundException;

	List<Teacher> getTeachersWithMoreYearsExperience(int experience); //throws EntityNotFoundException, InvalidNumberException;

}
