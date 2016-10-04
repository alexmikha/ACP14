package studyart.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

/**
 * Created by serhii on 04.09.16.
 */
public class IOUtils {

    public static String readAll(InputStream is) {
        BufferedReader bis = new BufferedReader(
                new InputStreamReader(is));
        // Stream -> collect
        return bis.lines().collect(Collectors.joining("\n"));
    }
}
