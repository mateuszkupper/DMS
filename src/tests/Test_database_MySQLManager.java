package tests;

import java.util.ArrayList;
import java.util.List;

import business_objects.Document;
import business_objects.Notification;
import business_objects.Permission;
import business_objects.Section;
import business_objects.User;
import database.DbManager;
import database.MySQLManager;

public class Test_database_MySQLManager {

	public static void main(String[] args) {
		testPermission();
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
	
	private static void testUser() {
		User user = new User();
		MySQLManager mysqlManager = new MySQLManager();
		user = (User)DbManager.retrieve(user.getClass(), 4, mysqlManager);
		System.out.println(user.getName());
		User newuser = new User();
		newuser.setName("eyryrf");
		DbManager.persist(newuser, mysqlManager);
		user.setName("newname");
		DbManager.update(user, mysqlManager);
		List<User> list1 = (List<User>)DbManager.retrieveList(newuser.getClass(), "name", "ewf", mysqlManager);
		for(User secr : list1) {
			System.out.println(secr.getName());
		}
		DbManager.delete(user, mysqlManager);
	}
	
	private static void testNotification() {
		Notification notification = new Notification();
		MySQLManager mysqlManager = new MySQLManager();
		notification = (Notification)DbManager.retrieve(notification.getClass(), 6, mysqlManager);
		System.out.println(notification.getDetails());
		Notification newn = new Notification();
		newn.setDetails("new");
		DbManager.persist(newn, mysqlManager);
		notification.setDetails("newname");
		DbManager.update(notification, mysqlManager);
		List<Notification> list = (List<Notification>)DbManager.retrieveList(newn.getClass(), "details", "ewfwf", mysqlManager);
		for(Notification secr : list) {
			System.out.println(secr.getDetails());
		}
		DbManager.delete(notification, mysqlManager);
	}
	
	private static void testPermission() {
		Permission permission = new Permission();
		MySQLManager mysqlManager = new MySQLManager();
		permission = (Permission)DbManager.retrieve(permission.getClass(), 3, mysqlManager);
		System.out.println(permission.getPermissions());
		System.out.println(permission.getDocument().getTitle());
		Permission permnew = new Permission();
		permnew.setPermissions(29);
		permnew.setDocument(permission.getDocument());
		permnew.setUser(permission.getUser());
		DbManager.persist(permnew, mysqlManager);
		permission.setPermissions(30);
		DbManager.update(permission, mysqlManager);
		List<Permission> list = (List<Permission>)DbManager.retrieveList(permnew.getClass(), "permissions", "7", mysqlManager);
		for(Permission secr : list) {
			System.out.println(secr.getPermissions());
		}
		DbManager.delete(permission, mysqlManager);
	}
}
