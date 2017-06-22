package dms.utils;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLRetriever {
	public static String getValueByXPath(String xpathString)
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		try {
			Document doc = loadXMLFile();
			XPathFactory xPathfactory = XPathFactory.newInstance();
			XPath xpath = xPathfactory.newXPath();
			XPathExpression expr = xpath.compile(xpathString);
			NodeList nList = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			Node nNode = nList.item(0);
			Element element = (Element) nNode;
			return element.getTextContent();
		} catch (XPathExpressionException e) {
			throw new XPathExpressionException("XPath Exception");
		}
	}

	public static Document loadXMLFile() throws ParserConfigurationException, SAXException, IOException {
		try {
			File fXmlFile = new File("src/config.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			return doc;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			throw new ParserConfigurationException();
		}
	}
}
