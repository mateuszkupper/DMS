package dms.database;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;
import org.xml.sax.SAXException;

import dms.utils.XMLRetriever;

public class LightCouchManager {
	public static CouchDbClient getCouchDbClient() throws NumberFormatException, XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		CouchDbProperties properties = new CouchDbProperties()
				  .setDbName(XMLRetriever.getValueByXPath("/config/db/couchdb/db"))
				  .setCreateDbIfNotExist(true)
				  .setProtocol("http")
				  .setHost(XMLRetriever.getValueByXPath("/config/db/couchdb/host"))
				  .setPort(Integer.valueOf(XMLRetriever.getValueByXPath("/config/db/couchdb/port")))
				  .setUsername(XMLRetriever.getValueByXPath("/config/db/couchdb/username"))
				  .setPassword(XMLRetriever.getValueByXPath("/config/db/couchdb/password"));

		return new CouchDbClient(properties);		
	}
}
