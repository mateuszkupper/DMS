package dms.services.security;

import java.util.List;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import dms.business_objects.User;
import dms.database.DbManager;
import dms.database.MySQLManager;

public class SecurityProfile {	
	@SuppressWarnings("unchecked")
	public static User getUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    List<User> userList =  (List<User>) DbManager.retrieveList(User.class, "username", authentication.getName(), new MySQLManager());
		    return userList.get(0);
		}
		return null;		
	}
	
}
