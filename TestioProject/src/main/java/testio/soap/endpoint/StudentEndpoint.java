package testio.soap.endpoint;

import testio.dto.StudentDTO;
import testio.dto.StudentList;
import testio.exception.NoStudentFoundException;
import testio.service.RegisterException;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by Mi on 27.10.16.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface StudentEndpoint {

    @WebMethod
    StudentDTO login(String login) throws NoStudentFoundException;

    @WebMethod
    StudentDTO getStudentInfo(int id) throws NoStudentFoundException;

    @WebMethod
    StudentDTO register(StudentDTO newStudent) throws RegisterException;

    @WebMethod
    StudentList getAll(int start, int lenght);

}
