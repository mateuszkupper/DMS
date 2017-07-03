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
@SuppressWarnings("unchecked")
public class DocumentController {	
	@GetMapping(path = "/documents", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Document> getDocuments() {
		return (List<Document>) DbManager.retrieveAll(Document.class, new MySQLManager());
	}	

	@GetMapping(path = "/user/{userid}/documents", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Document> getDocumentsForUser(@PathVariable int userid)  {
		List<Permission> permissions = (List<Permission>) DbManager.retrieveList(Permission.class,
									"user_id", String.valueOf(userid), new MySQLManager());
		if(permissions!=null) {
			List<Document> documentsForUser = new ArrayList<Document>();
			for(Permission permission : permissions) {
				documentsForUser.add(permission.getDocument());
			}
			return documentsForUser;
		} else {
			return null;
		}
	}

	@GetMapping(path = "/document/{documentid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Document getDocument(@PathVariable int documentid) {
		return (Document)DbManager.retrieve(Document.class, String.valueOf(documentid), new MySQLManager());
	}	
}
