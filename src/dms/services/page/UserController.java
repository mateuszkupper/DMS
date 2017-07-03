package dms.services.page;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dms.business_objects.User;
import dms.database.DbManager;
import dms.database.MySQLManager;

@SuppressWarnings("unchecked")
@RestController
public class UserController {	
	@GetMapping(path = "/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<User> getUsers() {
		return (List<User>) DbManager.retrieveAll(User.class, new MySQLManager());
	}	

	@GetMapping(path = "/user/{userid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody User getUser(@PathVariable int userid) {
		return (User)DbManager.retrieve(User.class, String.valueOf(userid), new MySQLManager());
	}
}
