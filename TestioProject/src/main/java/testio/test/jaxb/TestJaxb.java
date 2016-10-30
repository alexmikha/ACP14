package testio.test.jaxb;

import testio.dto.StudentDTO;
import testio.dto.StudentList;
import testio.model.StudentType;

import javax.xml.bind.JAXB;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

/**
 * Created by Mi on 27.10.16.
 */
public class TestJaxb {

    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        StudentDTO serhii = new StudentDTO(1, "serhii", StudentType.JUNIOR);
        studentList.setDtoList(Arrays.asList(serhii,
                new StudentDTO(2, "ivan", StudentType.JUNIOR)));


        StringWriter writer = new StringWriter();

        JAXB.marshal(studentList, writer);

        String res = writer.toString();

        System.out.println(res);

        StudentList unmarshaled = JAXB.unmarshal(new StringReader(res), StudentList.class);

        System.out.println();






    }
}
