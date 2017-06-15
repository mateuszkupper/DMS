package tests;

import business_objects.Document;
import database.DbManager;
import database.MySQLManager;

public class Test_database_MySQLManager {

	public static void main(String[] args) {
		Document doc = new Document();
		MySQLManager mysqlManager = new MySQLManager();
		DbManager.retrieve(doc.getClass(), "1", mysqlManager);
		
		  
	}

}
