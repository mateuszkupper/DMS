package dms.tests;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.lightcouch.CouchDbClient;
import org.xml.sax.SAXException;

import com.google.gson.JsonObject;

import dms.business_objects.Section;
import dms.database.DbManager;
import dms.database.LightCouchManager;
import dms.database.MySQLManager;

public class Test_database_CouchDbManager {

	public static void main(String[] args) {
		testDocument();
	}
	
	private static void testDocument() {
		Section section = (Section)DbManager.retrieve(Section.class, String.valueOf("26"), new MySQLManager());
		CouchDbClient couchDbClient;
		try {
			couchDbClient = LightCouchManager.getCouchDbClient();
			System.out.println(couchDbClient.find(JsonObject.class, section.getCouch_db_section_id()).toString());				
		} catch (NumberFormatException | XPathExpressionException | ParserConfigurationException | SAXException
				| IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
