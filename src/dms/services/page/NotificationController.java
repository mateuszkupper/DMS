package dms.services.page;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dms.business_objects.Notification;
import dms.database.DbManager;
import dms.database.MySQLManager;

@RestController
@SuppressWarnings("unchecked")
public class NotificationController {	
	@GetMapping(path = "/notifications", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Notification> getNotifications() {
		return (List<Notification>) DbManager.retrieveAll(Notification.class, new MySQLManager());
	}	

	@GetMapping(path = "/notification/{notificationid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Notification getNotification(@PathVariable int notificationid) {
		return (Notification)DbManager.retrieve(Notification.class, String.valueOf(notificationid), new MySQLManager());
	}
	
	@GetMapping(path = "/user/{userid}/notifications", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Notification> getNotificationsForUser(@PathVariable int userid)  {
		return null;
//		List<Permission> permissions = (List<Permission>) DbManager.retrieveList(Permission.class,
//									"user_id", String.valueOf(userid), new MySQLManager());
//		if(permissions!=null) {
//			List<Document> documentsForUser = new ArrayList<Document>();
//			for(Permission permission : permissions) {
//				documentsForUser.add(permission.getDocument());
//			}
//			return documentsForUser;
//		} else {
//			return null;
//		}
	}


}
