package dms.services.page;

import java.util.List;
import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dms.business_objects.Document;
import dms.business_objects.Section;
import dms.database.DbManager;
import dms.database.MySQLManager;

@SuppressWarnings("unchecked")
@RestController
public class SectionController {	
	@GetMapping(path = "/sections", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Section> getPermissions() {
		return (List<Section>) DbManager.retrieveAll(Section.class, new MySQLManager());
	}	

	@GetMapping(path = "/section/{sectionid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Section getSection(@PathVariable int sectionid) {
		return (Section)DbManager.retrieve(Section.class, String.valueOf(sectionid), new MySQLManager());
	}
	
	@GetMapping(path = "/document/{documentid}/sections", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Set<Section> getSectionsForDocument(@PathVariable int documentid) {
		Document document = (Document)DbManager.retrieve(Document.class, String.valueOf(documentid), new MySQLManager());
		if (document!=null) {
			return document.getSections();	
		} else {
			return null;
		}		
	}	
}
