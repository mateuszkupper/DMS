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

@SuppressWarnings("unchecked")
@RestController
public class ParagraphController {	
//	@GetMapping(path = "/notificatios", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public @ResponseBody List<Notification> getNotifications() {
//		return (List<Notification>) DbManager.retrieveAll(Notification.class, new MySQLManager());
//	}	
//
//	@GetMapping(path = "/notification/{notificationid}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public @ResponseBody Notification getNotifications(@PathVariable int notificationid) {
//		return (Notification)DbManager.retrieve(Notification.class, String.valueOf(notificationid), new MySQLManager());
//	}
}
