package business_objects;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "user")
public class User {
	
	@Id
	private int id;
	
	@Column(name = "`name`")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Permission> permissions;
	
	public User(int id, String name, List<Permission> permissions) {
		this.id = id;
		this.name = name;
		this.permissions = permissions;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
