package testio.soap.endpoint;

import testio.dto.StudentDTO;
import testio.dto.StudentList;
import testio.exception.NoStudentFoundException;
import testio.model.Student;
import testio.service.RegisterException;
import testio.service.StudentService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mi on 27.10.16.
 */
@WebService(endpointInterface = "testio.soap.endpoint.StudentEndpoint")
public class StudentEndpointImpl implements StudentEndpoint {

    private StudentService studentService;

    public StudentEndpointImpl() {
    }

    public StudentEndpointImpl(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public StudentDTO login(String login) throws NoStudentFoundException {
        Student student = studentService.login(login);
        return new StudentDTO(student.getId(),student.getName(),student.getStudentType());
    }

    @Override
    public StudentDTO getStudentInfo(int id) throws NoStudentFoundException {
        Student student = studentService.getStudentInfo(id);
        return new StudentDTO(student.getId(),student.getName(),student.getStudentType());
    }

    @Override
    public StudentDTO register(StudentDTO newStudent) throws RegisterException {
        Student student = studentService.register(new Student(newStudent.getName(),0.0,newStudent.getStudentType(),null,null));
        return new StudentDTO(student.getId(),student.getName(),student.getStudentType());
    }

    @Override
    public StudentList getAll(int start, int lenght) {


        List<Student> students = studentService.getAll(start,lenght);
        return getStudentList(students);
    }

    private StudentList getStudentList(List<Student> students) {
        StudentList studentList;
        studentList = new StudentList();
        List<StudentDTO> studentDTOs = new ArrayList<>();

        for (Student student : students) {
            studentDTOs.add(new StudentDTO(student.getId(),student.getName(),student.getStudentType()));
        }

        studentList.setDtoList(studentDTOs);

        return studentList;
    }


}
