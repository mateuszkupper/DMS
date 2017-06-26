package dms.services.page;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dms.business_objects.Document;
import dms.business_objects.Permission;
import dms.business_objects.Section;
import dms.business_objects.User;
import dms.database.DbManager;
import dms.database.MySQLManager;

@RestController
public class DocumentController {
	
    @RequestMapping("/")
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }	
	
	@GetMapping(path = "/user/{userid}/documents", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getDocumentsForUser(@PathVariable int userid) {
		MySQLManager mysqlManager = new MySQLManager();
		User user = (User) DbManager.retrieve(User.class, userid, mysqlManager);
		Set<Permission> permissions = user.getPermissions();
		String JSON = generateDocumentJSON(permissions);
		return JSON;
	}
	
	private String generateDocumentJSON(Set<Permission> permissions) {
		String JSONString = " { ";
		JSONString += " \"documents\":  [";
		int size = permissions.size();
		int iter = 0;
		for(Permission permission : permissions) {
			iter++;
			JSONString += " { ";
			Document document = permission.getDocument();
			Set<Section> sections = document.getSections();
			JSONString += " \"id\": " + document.getId() + ", ";
			JSONString += " \"title\": \"" + document.getTitle() + "\", ";
			JSONString += " \"permissions\": " + permission.getPermissions() + ", ";
			if(document.getMasterDocument()!=null) {
				JSONString += " \"masterDocId\": " + document.getMasterDocument().getId() + ", ";
			}
			JSONString += " \"sections\": [";
			int sectionssize = sections.size();
			int itersection = 0;
			for(Section section : sections) {
				itersection++;
				JSONString += " { ";				
				JSONString += " \"id\": " + section.getId() + ", ";
				JSONString += " \"title\": \"" + section.getTitle() + "\" ";
				JSONString += " } ";
				if(itersection!=sectionssize) {
					JSONString += " , ";	
				}				
			}
			JSONString += "] } ";
			if(iter!=size) {
				JSONString += " , ";	
			}
		}
		JSONString += "] } ";
		
		
		for (Field field : Document.class.getDeclaredFields()) {
			JSONString += field.getName();
		}
		return JSONString;
	}
	
	@GetMapping(path = "/whtv", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Document> getDocuments() {
		MySQLManager mysqlManager = new MySQLManager();
		List<Document> documents = (List<Document>) DbManager.retrieveAll(Document.class, mysqlManager);
		return documents;
	}	
	
}
