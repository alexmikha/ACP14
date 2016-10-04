package homeWork.json;

import com.google.gson.Gson;
import utils.NetUtils;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by mi on 16.09.2016.
 */
public class JsonPerser {

    private static final String PATH = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
    private static String PRIVAT_HOME_JSON_PATH = "OleksandrMykhailov/src/main/resources/document/privat_home.json";

    public static void main(String[] args) throws IOException, URISyntaxException {
        Gson gson = new Gson();
        NetUtils.load(PATH, PRIVAT_HOME_JSON_PATH);
        CashCoursePrivat[] privatbank = gson.fromJson(new FileReader(PRIVAT_HOME_JSON_PATH), CashCoursePrivat[].class);
        for (CashCoursePrivat cashCoursePrivat : privatbank) {
            System.out.println(cashCoursePrivat.toString());
        }
    }
}
