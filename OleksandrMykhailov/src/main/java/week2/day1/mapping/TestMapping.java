package week2.day1.mapping;

import com.google.gson.Gson;
import utils.NetUtils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by mi on 14.09.2016.
 */
public class TestMapping {

    public static final String PATH = "https://api.privatbank.ua/p24api/pboffice?json&city=Днепропетровск&address=Титова";
    public static final String PRIVAT_JSON_PATH = "OleksandrMykhailov/src/main/resources/document/privat.json";

    public static void main(String[] args) throws IOException, URISyntaxException {
        Gson gson = new Gson();

        String jsonDep = gson.toJson(new DepartmentPrivatBank("name", "sdd", 1, "UA",
                "Kyiv", 1232, "2345", "ua@gmail.com", "qawsed"));

        System.out.println(jsonDep);


        NetUtils.load(PATH, PRIVAT_JSON_PATH); //"resources/privat.json");
        DepartmentPrivatBank[] departments = gson.fromJson(new FileReader(PRIVAT_JSON_PATH), DepartmentPrivatBank[].class);

        for (DepartmentPrivatBank department : departments) {
            System.out.println(department);
        }

    }
}