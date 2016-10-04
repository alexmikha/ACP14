package week2.day1.net;

import utils.NetUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by mi on 13.09.2016.
 */
public class TestNetUtils {


    public static void main(String[] args) throws IOException, URISyntaxException {
        NetUtils.load("http://www.ex.ua/get/272813793", "OleksandrMykhailov/src/main/resources/document/audio.mp3");

    }
}
