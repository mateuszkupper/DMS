package dms.services.page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dms.business_objects.Document;
import dms.database.DbManager;
import dms.database.MySQLManager;

@RestController
public class DocumentController {
	
    @RequestMapping("/")
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }	
	
	@GetMapping("/documents")
	public String getDocument() {
		MySQLManager mysqlManager = new MySQLManager();
		Document doc = (Document)DbManager.retrieve(Document.class, 5, mysqlManager);
		return doc.getTitle();
	}
	
}
