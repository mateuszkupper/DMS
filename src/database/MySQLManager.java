package database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import business_objects.Document;
import business_objects.Notification;
import business_objects.Permission;
import business_objects.Section;
import business_objects.User;  

public class MySQLManager implements PhysicalDBImplementation {
	private static StandardServiceRegistry standardRegistry;
	private static Metadata metadata;
	
	static {
		 standardRegistry = new StandardServiceRegistryBuilder()
				 .configure("hibernate.cfg.xml")				 
				 .build();
		 metadata = new MetadataSources(standardRegistry)
				 .addAnnotatedClass(Document.class)
				 .addAnnotatedClass(Notification.class)
				 .addAnnotatedClass(Section.class)
				 .addAnnotatedClass(User.class)
				 .getMetadataBuilder()
				 .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE )
				 .build();
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
		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
	    return sessionFactory.openSession();     		
	}
}
