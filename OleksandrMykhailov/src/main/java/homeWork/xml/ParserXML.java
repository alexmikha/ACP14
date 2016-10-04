package homeWork.xml;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import utils.NetUtils;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by mi on 16.09.2016.
 */
public class ParserXML {

    private static final String PATH_XML = "https://privat24.privatbank.ua/p24/accountorder?oper=prp&PUREXML&apicour&country=ua"; //"https://api.privatbank.ua/p24api/pubinfo?exchange&coursid=5";
    private static final String PRIVAT_HOME_XML = "OleksandrMykhailov/src/main/resources/document/privat_home.xml";

    public static void parserXml(String path) throws ParserConfigurationException, IOException, SAXException, URISyntaxException {
        NetUtils.load(PATH_XML, PRIVAT_HOME_XML);
        //       try {
        URL url = new URL("https://privat24.privatbank.ua/p24/accountorder?oper=prp&PUREXML&apicour&country=ua");
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        // Document document = documentBuilder.parse(new File(PRIVAT_HOME_XML));
        Document document = documentBuilder.parse(new InputSource(url.openStream()));
        document.getDocumentElement().normalize();

        NodeList nodeList = document.getElementsByTagName("exchangerate");
        Node node = nodeList.item(0);

        // опускаемся на узел ниже и получаем список его атрибутов
        NamedNodeMap attributes = node.getFirstChild().getAttributes();
        //получаем значение атрибут buy
        Node currencyAttribEUR = attributes.getNamedItem("buy");
        // ... и его значение
        String currencyValueEUR = currencyAttribEUR.getNodeValue();

        NamedNodeMap attributes1 = node.getLastChild().getAttributes();
        Node currencyAttribDOL = attributes1.getNamedItem("buy");
        String currencyValueDOL = currencyAttribDOL.getNodeValue();

        // аналогично поступаем с датой, чтобы иметь представление о актуальности
        Node dateCurrency = attributes.getNamedItem("date");
        String dateCurrencyStr = dateCurrency.getNodeValue();

        System.out.println("Курс евро на " + dateCurrencyStr + " : " + currencyValueEUR + " коп");
        System.out.println("Курс доллара на " + dateCurrencyStr + " : " + currencyValueDOL + " коп");

//        Element root = document.getDocumentElement();
//
//        System.out.printf("root %s, attribut %s\n", root.getTagName(), root.getTagName());
//
//        NodeList nodeList = root.getChildNodes();
//
//        int i;
//        for (i = 0; i < nodeList.getLength(); i++) {
//            Node node = nodeList.item(i);
//
//            if (node.getNodeType() == Node.ELEMENT_NODE) {
//                Element element = (Element) node;
//                System.out.println(element.getTagName());
//            } else if (node.getNodeType() == Node.TEXT_NODE) {
//
//            }
//        } catch (Exception e) {
//            System.out.println("Не удалось выполнить операцию");
//        };
        //  ;
        //      System.out.println("sise: " + nodeList.getLength());
        //  return currencyValueEUR;
        // }
    }

    public static String getPrivatHomeXml() {
        return PRIVAT_HOME_XML;
    }
}
