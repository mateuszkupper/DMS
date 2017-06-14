package database;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;

import java.util.List;  

public class MySQLManager implements PhysicalDBImplementation {
	private static Configuration hibernateConfig;
	
	static {
	    hibernateConfig = new Configuration();  
	    hibernateConfig.configure("hibernate.cfg.xml"); 
	}
	
	@Override
	public Object retrieve(Class<?> c, String id) {
	    Session session = getHibernateSession(); 
	    Transaction transaction = session.beginTransaction();  			
        Object obj = (Object)session.get(c, id);     
	    transaction.commit(); 
	    session.close();	
		return obj;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> retrieveList(Class<?> c, String attribute, String value) {
	    Session session = getHibernateSession(); 
	    Transaction transaction = session.beginTransaction();  			
	    List<Object> list = session.createQuery("FROM " + c.getName() + " SELECT * WHERE "
	    										+ attribute + " = " + value + ";").list();   
	    transaction.commit(); 
	    session.close();	
		return list; 
	}	
	
	@Override
	public void persist(Object object) {
	    Session session = getHibernateSession(); 
	    Transaction transaction = session.beginTransaction();        
	    session.persist(object);        
	    transaction.commit(); 
	    session.close();  		
	}

	@Override
	public void update(Object object) {
	    Session session = getHibernateSession(); 
	    Transaction transaction = session.beginTransaction();  			
		session.update(object);        
	    transaction.commit(); 
	    session.close();		
	}

	@Override
	public void delete(Object object) {
	    Session session = getHibernateSession(); 
	    Transaction transaction = session.beginTransaction();  			
		session.delete(object);        
	    transaction.commit(); 
	    session.close();
	}
	
	private Session getHibernateSession() {
	    SessionFactory factory = hibernateConfig.buildSessionFactory();  
	    return factory.openSession();     		
	}
}
