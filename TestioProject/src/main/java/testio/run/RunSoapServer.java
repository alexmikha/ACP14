package testio.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import testio.service.StudentService;
import testio.soap.endpoint.StudentEndpointImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by Mi on 27.10.16.
 */
public class RunSoapServer {

    public static void main(String[] args) {

        ApplicationContext appCon = new ClassPathXmlApplicationContext("spring-context.xml");
        StudentService studentService;
        studentService = appCon.getBean(StudentService.class);


        Endpoint.publish(
                "http://192.168.0.105:1099/soap/student", new StudentEndpointImpl(studentService));


    }
}
