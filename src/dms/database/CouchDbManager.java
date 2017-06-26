package dms.database;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.ektorp.*;
import org.ektorp.impl.*;
import org.xml.sax.SAXException;

import dms.utils.*;

import java.util.List;

import org.ektorp.http.*;

public class CouchDbManager implements PhysicalDBImplementation {

	@Override
	public Object retrieve(Class<?> c, int id) {
		try {
			CouchDbConnector db = getConnector();
			return db.get(c, String.valueOf(id));
		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void persist(Object object) {
		try {
			CouchDbConnector db = getConnector();
			db.create(object);
		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Object object) {
		try {
			CouchDbConnector db = getConnector();
			db.update(object);
		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Object object) {
		try {
			CouchDbConnector db = getConnector();
			db.delete(object);
		} catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
	}

	private CouchDbConnector getConnector()
			throws XPathExpressionException, ParserConfigurationException, SAXException, IOException {
		HttpClient authenticatedHttpClient = new StdHttpClient.Builder()
				.url(XMLRetriever.getValueByXPath("/config/db/couchdb/url"))
				.username(XMLRetriever.getValueByXPath("/config/db/couchdb/username"))
				.password(XMLRetriever.getValueByXPath("/config/db/couchdb/password")).build();

		CouchDbInstance dbInstance = new StdCouchDbInstance(authenticatedHttpClient);
		return dbInstance.createConnector("my_first_database", true);
	}

	@Override
	public List<Object> retrieveList(Class<?> c, String attribute, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> retrieveAll(Class<?> c) {
		// TODO Auto-generated method stub
		return null;
	}
}
