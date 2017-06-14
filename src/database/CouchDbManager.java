package database;
import java.net.MalformedURLException;

import org.ektorp.*;
import org.ektorp.impl.*;
import org.ektorp.http.*;

public class CouchDbManager implements PhysicalDBImplementation {

	@Override
	public Object retrieve(Class<?> c, String attribute, String value) {
		try {
			CouchDbConnector db = getConnector();
			return db.get(c, value);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}	
	}

	@Override
	public void persist(Object object) {	
		try {
			CouchDbConnector db = getConnector();
			db.create(object);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}			
	}

	@Override
	public void update(Object object) {
		try {
			CouchDbConnector db = getConnector();
			db.update(object);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Object object) {
		try {
			CouchDbConnector db = getConnector();
			db.delete(object);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	private CouchDbConnector getConnector() throws MalformedURLException {
		HttpClient authenticatedHttpClient = new StdHttpClient.Builder()
		        .url("http://127.0.0.1:5984")
		        .username("admin")
		        .password("password")
		        .build();//TODO use XML config

		CouchDbInstance dbInstance = new StdCouchDbInstance(authenticatedHttpClient);
		return dbInstance.createConnector("my_first_database", true);//TODO use XML config
	}
}
