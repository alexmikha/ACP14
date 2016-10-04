package week3.server;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by mi on 9/18/16.
 */
public class PropertiesHolder {

    private static final Properties PROP = init();

    private static Properties init(){
        Properties properties = new Properties();

        try {
            properties.load(PropertiesHolder.class
                    .getResourceAsStream("/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }

    public static String get(String key) {
        return PROP.getProperty(key);
    }
}
