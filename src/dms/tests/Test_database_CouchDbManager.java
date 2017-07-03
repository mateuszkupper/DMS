package dms.tests;

import java.util.Date;

import dms.business_objects.Paragraph;
import dms.database.CouchDbManager;
import dms.database.DbManager;

public class Test_database_CouchDbManager {

	public static void main(String[] args) {
		testDocument();
	}
	
	private static void testDocument() {
		String textPara = "poarapoarapoarapoarapoarapoarapoarapoara";
		Paragraph para = new Paragraph(2, textPara, new Date(), "sadasdasda", 0);
		DbManager.persist(para, new CouchDbManager());
		Paragraph para2 = (Paragraph)DbManager.retrieve(Paragraph.class, "6e627226b64e1300642f40d262000bde", 
									new CouchDbManager());
		
		System.out.println(para2.getText());		
	}
}
