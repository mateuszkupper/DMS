package dms.services.page;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dms.business_objects.Document;
import dms.business_objects.Notification;
import dms.business_objects.Permission;
import dms.business_objects.Section;
import dms.business_objects.User;
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
		User user = (User) DbManager.retrieve(User.class, String.valueOf(userid), new MySQLManager());
		if(user!=null) {
			Set<Permission> permissionsForUser = user.getPermissions();
			List<Document> documentsForUser = new ArrayList<Document>();		
			for (Permission permission : permissionsForUser) {
				Document documentForPermission = permission.getDocument();
				documentsForUser.add(documentForPermission);
			}
			
			List<Notification> notificationsForUser = new ArrayList<Notification>();
			for(Document document : documentsForUser) {
				Set<Section> sectionsForDocument = document.getSections();
				for(Section section : sectionsForDocument) {
					Set<Notification> notificationForSection = section.getNotificationsForSlaveSections();
					for(Notification notification : notificationForSection) {
						notificationsForUser.add(notification);
					}
				}
			}
			return notificationsForUser;
		} else {
			return null;
		}
	}
}
