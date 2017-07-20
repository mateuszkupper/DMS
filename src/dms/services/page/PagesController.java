package dms.services.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PagesController {
    @RequestMapping(path = "/login", method = RequestMethod.GET, produces = "text/html")
    public String displayLogin() {
    	return "/login.jsp";
    }
    
    @RequestMapping(path = "/", method = RequestMethod.GET, produces = "text/html")
    public String displayHome() {
    	return "/home.jsp";
    }
    
    @RequestMapping(path = "/doc/{docid}", method = RequestMethod.GET, produces = "text/html")
    public String displayDocument() {
    	return "/home.jsp";
    } 
    
    @RequestMapping(path = "/sec/{secid}", method = RequestMethod.GET, produces = "text/html")
    public String displaySection() {
    	return "/home.jsp";
    }     
}
