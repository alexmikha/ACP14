package week1.day1;

import studyart.controller.TaskControllerImpl;
import studyart.model.Task;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * Created by mi on 04.09.16.
 */
public class TestReflection {

    public static void main(String[] args) {
        Task task = new Task(1, "Some", "/ACP14/resources");
        getAllInfo(task);

        TaskControllerImpl taskController = new TaskControllerImpl(null, null);
        getAllInfo(taskController);

    }

    public static void getAllInfo(Object object) {
        Class cl = object.getClass();

        // new
//        try {
//            Object newInstance = cl.newInstance();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

        Field[] fields = cl.getDeclaredFields();

        System.out.println("FIELDS");
        Arrays.stream(fields).forEach(System.out::println);

        System.out.println("Methods");
        Arrays.stream(cl.getDeclaredMethods()).forEach(System.out::println);

        System.out.println("Constructors");
        Arrays.stream(cl.getDeclaredConstructors()).forEach(System.out::println);

    }

}
