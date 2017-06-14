package database;

public class DbManager {
	public static Object retrieve(Class<?> c, String attribute, String value,
			PhysicalDBImplementation DBImplementation) {
		DBImplementation.retrieve(c, attribute, value);
		return null;
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
