package database;

public class DbManager {
	public static Object retrieveList(Class<?> c, String attribute, String value,
			PhysicalDBImplementation DBImplementation) {
		return DBImplementation.retrieveList(c, attribute, value);
	}

	public static Object retrieve(Class<?> c, int id, PhysicalDBImplementation DBImplementation) {		
		return DBImplementation.retrieve(c, id);
	}	
	
	public static void persist(Object object, PhysicalDBImplementation DBImplementation) {
		DBImplementation.persist(object);
	}

	public static void update(Object object, PhysicalDBImplementation DBImplementation) {
		DBImplementation.update(object);
	}

	public static void delete(Object object, PhysicalDBImplementation DBImplementation) {
		DBImplementation.delete(object);
	}
	
}
