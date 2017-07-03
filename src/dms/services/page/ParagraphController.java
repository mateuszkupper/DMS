package dms.services.page;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dms.business_objects.Document;
import dms.business_objects.Permission;
import dms.database.DbManager;
import dms.database.MySQLManager;

@RestController
public class ParagraphController {	
	@SuppressWarnings("unchecked")
	@GetMapping(path = "/documents", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Document> getDocuments() {
		MySQLManager mysqlManager = new MySQLManager();
		List<Document> documents = (List<Document>) DbManager.retrieveAll(Document.class, mysqlManager);
		return documents;
	}	

	@SuppressWarnings("unchecked")
	@GetMapping(path = "/user/{userid}/documents", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Document> getDocumentsForUser(@PathVariable int userid)  {
		MySQLManager mysqlManager = new MySQLManager();
		List<Permission> permissions = (List<Permission>) DbManager.
									retrieveList(Permission.class,
									"user_id", String.valueOf(userid), mysqlManager);
		List<Document> documentsForUser = new ArrayList<Document>();
		for(Permission permission : permissions) {
			documentsForUser.add(permission.getDocument());
		}
		return documentsForUser;
	}
}
