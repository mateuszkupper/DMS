package dms.services.page;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {
	
	@GetMapping("/customers")
	public String getDocument() {
		
		return "doc";		
	}
	
}
