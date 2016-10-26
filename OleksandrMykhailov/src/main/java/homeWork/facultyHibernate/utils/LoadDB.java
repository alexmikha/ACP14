package homeWork.facultyHibernate.utils;

import homeWork.facultyHibernate.model.Group;
import homeWork.facultyHibernate.model.Student;
import homeWork.facultyHibernate.model.Subject;
import homeWork.facultyHibernate.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;


/**
 * Created by Mi on 23.10.2016.
 */
public class LoadDB {

    private static EntityManager manager;

    public static void addDataIntoDB() {
        manager = MenagerConection.getManagerConnection();
//        addDataIntoGroupsTable();
//        addDataIntoSubjectsTable();
        addDataIntoStudentsGroupsTable();
//         addDataIntoStudensTable();
        addDataIntoTeachersSubjectsTable();
    }


    private static void addDataIntoTeachersSubjectsTable() {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        for (int i = 0; i < 5; i++) {
            Subject subject = new Subject("IT_" + i + 1, "desc" + i + 1);
            manager.persist(new Teacher("Teacher_" + i + 1, 10, subject));
            manager.persist(subject);
        }
        transaction.commit();
    }


    private static void addDataIntoStudensTable() {
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        for (int i = 0; i < 15; i++) {

            manager.persist(new Student("Student_" + i + 1, new Group("IT_" + i + 1)));
        }
        transaction.commit();
    }

    private static void addDataIntoStudentsGroupsTable() {
        Group group;
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 4; j++) {

                group = new Group("IT_" + j);
                manager.persist(new Student("Student_" + i, group));
            }
        }
        transaction.commit();
    }

    public static void deleteFromTables(){
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();
        manager.createQuery("DELETE FROM Student").executeUpdate();
        manager.createQuery("DELETE FROM Group").executeUpdate();
        manager.createQuery("DELETE FROM Subject").executeUpdate();
        manager.createQuery("DELETE FROM Teacher").executeUpdate();
        transaction.commit();
        manager.close();
    }
}
