package dms.services.page;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dms.business_objects.Permission;
import dms.database.DbManager;
import dms.database.MySQLManager;

@SuppressWarnings("unchecked")
@RestController
public class PermissionController {	
	@GetMapping(path = "/permissions", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Permission> getPermissions() {
		return (List<Permission>) DbManager.retrieveAll(Permission.class, new MySQLManager());
	}	

	@GetMapping(path = "/permission/{permissionid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Permission getPermission(@PathVariable int permissionid) {
		return (Permission)DbManager.retrieve(Permission.class, String.valueOf(permissionid), new MySQLManager());
	}
}
