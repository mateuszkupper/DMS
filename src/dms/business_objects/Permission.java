package dms.business_objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "users_documents")
public class Permission {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "permissions")
	private int permissions;

	@ManyToOne(targetEntity = Document.class)
	private Document document;

	@ManyToOne(targetEntity = User.class)
	private User user;

	public Permission() {

	}

	public Permission(int id, int permissions, Document document, User user) {
		this.permissions = permissions;
		this.document = document;
		this.id = id;
		this.user = user;
	}

	public int getPermissions() {
		return permissions;
	}

	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
