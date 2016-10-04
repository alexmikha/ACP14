package week2.day1.mapping;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * Created by mi on 13.09.2016.
 */
public class RunDomParser {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DomParsingUtils.parse(Constants.PATH);

    }
}
