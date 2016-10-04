import java.util.Arrays;
import java.util.Objects;

public class Task1Performed {

    public static void main(String[] args) {
        testGetId();
        testGetName();
    }


    private static void testGetId() {
        // before action, init data for test
        User user = new User(1, "Ivan");

        int expected = 1;
        int actual = user.getId();
        System.out.println(createTestMessageResult("getIdTest", expected, actual));
    }

    private static void testGetName() {
        User user = new User(1, "Ivan");

        String expected = "Ivan";
        String actual = user.getName();
        System.out.println(createTestMessageResult("getNameId", expected, actual));
    }

    private static String createTestMessageResult(String message,
                                                  Object expected,
                                                  Object actual, Object... in) {
        return String.format("message %s, res %s, expected %s, actual %s, in %s",
                message, Objects.equals(expected, actual), expected, actual, Arrays.toString(in));
    }

}

// student task
// add constructor(id,name), fields (id, name), add getters, overide equals
class User {

    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
