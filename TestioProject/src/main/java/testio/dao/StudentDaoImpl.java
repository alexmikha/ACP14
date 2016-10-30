package testio.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import testio.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;


/**
 * Created by Mi on 27.10.16.
 */
@Component
public final class StudentDaoImpl implements StudentDao {


    @PersistenceContext
    private EntityManager manager;


    @Override
    @Transactional
    public Student create(Student student) {
        manager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public Student remove(int id) {
        Student forRemove = manager.find(Student.class, id);
        manager.remove(forRemove);

        return forRemove;

    }

    @Override
    @Transactional
    public Student find(String login) {
        TypedQuery<Student> query = manager.createQuery("SELECT s FROM Student s WHERE s.name =:name", Student.class)
                .setParameter("name", login);
        List<Student> students = query.getResultList();

        if(students == null || students.isEmpty()){
            return null;
        }

        return students.get(0);
    }

    @Override
    @Transactional
    public Student find(int id) {


        return manager.find(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> getAll(int start, int end) {

        return manager.createQuery("SELECT s FROM Student s", Student.class)
                .setFirstResult(start).setMaxResults(end).getResultList();
    }
}
