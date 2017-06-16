package tests;

import java.util.ArrayList;
import java.util.List;

import business_objects.Document;
import business_objects.Section;
import database.DbManager;
import database.MySQLManager;

public class Test_database_MySQLManager {

	public static void main(String[] args) {
		testSection();
	}
	
	private static void testDocument() {
		Document doc = new Document();
		MySQLManager mysqlManager = new MySQLManager();
		doc = (Document) DbManager.retrieve(doc.getClass(), 1, mysqlManager);
		//System.out.println(doc.getTitle());
		doc.setTitle("title");
		DbManager.update(doc, mysqlManager);
		Document newdoc = new Document();
		newdoc.setTitle("new");
		List<Document> list = new ArrayList<Document>();
		list.add(doc);
		doc.setSlaveDocuments(list);
		newdoc.setMasterDocument(doc);
		DbManager.persist(doc, mysqlManager);
		Document doc5 = (Document) DbManager.retrieve(doc.getClass(), 15, mysqlManager);
		DbManager.delete(doc5, mysqlManager);
		List<Document> list1 = (List<Document>) DbManager.retrieveList(newdoc.getClass(), "title", "asd", mysqlManager);
		for(Document docr : list1) {
			System.out.println(docr.getTitle());		
		}					
	}
	
	private static void testSection() {
		Section sec = new Section();
		MySQLManager mysqlManager = new MySQLManager();
		sec = (Section)DbManager.retrieve(sec.getClass(), 41, mysqlManager);
		System.out.println(sec.getTitle());
		sec.setTitle("dsf");
		DbManager.update(sec, mysqlManager);
		Section newsec = new Section();
		newsec.setTitle("new");
		List<Section> list = new ArrayList<Section>();
		list.add(sec);
		sec.setSubsequentVersions(list);
		newsec.setPreviousVersion(sec);
		DbManager.persist(sec, mysqlManager);
		Section sec6 = (Section)DbManager.retrieve(sec.getClass(), 40, mysqlManager);
		DbManager.delete(sec6, mysqlManager);
		List<Section> list1 = (List<Section>)DbManager.retrieveList(newsec.getClass(), "title", "ko0", mysqlManager);
		for(Section secr : list1) {
			System.out.println(secr.getTitle());
		}
	}
}
