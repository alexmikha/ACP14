package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by mi on 13.09.2016.
 */
public class NetUtils {

    public static void load(String url, String dest) throws URISyntaxException, IOException {
        try (InputStream inputStream = new URI(url).toURL().openStream();
             OutputStream os = new FileOutputStream(dest)) {
            byte[] buff = new byte[1024];
            int count = 0;

            while ((count = inputStream.read(buff)) != -1) {
                os.write(buff, 0, count);
                os.flush();

            }
        }
    }
}

