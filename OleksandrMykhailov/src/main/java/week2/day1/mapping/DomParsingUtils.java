package week2.day1.mapping;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;

import static javax.xml.parsers.DocumentBuilderFactory.newInstance;
import static week2.day1.mapping.Constants.PATH;

/**
 * Created by mi on 13.09.2016.
 */
public class DomParsingUtils {

    public static void parse(String path) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        Document document = documentBuilder.parse(new File(PATH));
        Element root = document.getDocumentElement(); // root -> team
        System.out.printf("root %s, attrib %s\n", root.getTagName(), root.getAttribute("id"));

        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println(element.getTagName());
            } else if (node.getNodeType() == Node.TEXT_NODE) {
            }
        }
        System.out.println("sise: " + nodeList.getLength());
    }

    public static String findByXPath(String xml) throws ParserConfigurationException,
            IOException, SAXException,  XPathExpressionException {
        Document document = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().parse(new File(xml));
        XPath xPath = XPathFactory.newInstance().newXPath();

        String getUserById = "//user[@id='1']";
        String getAddressOfUser = "//user[@id='1']/address";
        String getUserFromKiev = "//user[address[city='Kiev']]";
        String res = xPath.compile(getUserFromKiev).evaluate(document);
  //      return res;
        Node user = (Node) xPath.compile(getUserById)
                .evaluate(document, XPathConstants.NODE);
        Node users = (Node) xPath.compile(getUserFromKiev)
                .evaluate(document, XPathConstants.NODE);
        Node address = (Node) xPath.compile(getAddressOfUser)
                .evaluate(document, XPathConstants.NODE);
        return res;
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
        System.out.println(findByXPath(PATH));
    }
}

