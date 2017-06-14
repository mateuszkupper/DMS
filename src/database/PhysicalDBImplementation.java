package database;

public interface PhysicalDBImplementation {
	public Object retrieve(Class<?> c, String attribute, String value);
	public void persist(Object object);
	public void update(Object object);
	public void delete(Object object);
}
