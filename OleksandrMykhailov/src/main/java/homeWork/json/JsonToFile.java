package homeWork.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by mi on 16.09.2016.
 */
public class JsonToFile {

    private static final String PATH_JSON = "OleksandrMykhailov/src/main/resources/document/person.json";

    public static void main(String[] args) {

        JsonObject obj = new JsonObject();
        obj.addProperty("name", "Alex");
        obj.addProperty("age", new Integer(30));

        JsonArray list = new JsonArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");

        obj.add("messages", list);

        try {
            FileWriter file = new FileWriter(PATH_JSON);
            file.write(obj.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print(obj);

    }
}

