package dms.database;

public class DbManager {
	private PhysicalDBImplementation DBImplementation;
	
	public static Object retrieveList(Class<?> c, String attribute, String value,
			PhysicalDBImplementation DBImplementation) {
		return DBImplementation.retrieveList(c, attribute, value);
	}

	public static Object retrieve(Class<?> c, String idString, PhysicalDBImplementation DBImplementation) {
		return DBImplementation.retrieve(c, idString);
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
	
	public static Object retrieveAll(Class<?> c, PhysicalDBImplementation DBImplementation) {
		return DBImplementation.retrieveAll(c);
	}

	public PhysicalDBImplementation getDBImplementation() {
		return DBImplementation;
	}

	public void setDBImplementation(PhysicalDBImplementation dBImplementation) {
		DBImplementation = dBImplementation;
	}
}
