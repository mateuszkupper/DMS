package dms.business_objects;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name = "documents")
public class Document {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne(targetEntity=Document.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	@JoinColumn(name="master_id")
	private Document masterDocument;

	@OneToMany(mappedBy="masterDocument", targetEntity=Document.class)
	@LazyCollection(LazyCollectionOption.FALSE)
    private List<Document> slaveDocuments = new ArrayList<Document>();

	@OneToMany(cascade={CascadeType.ALL}, targetEntity=Section.class, mappedBy="document")
	@LazyCollection(LazyCollectionOption.FALSE)
    private List<Section> sections;

	@OneToMany(cascade = { CascadeType.ALL }, targetEntity = Permission.class, mappedBy = "document")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Permission> permissions;	
	
	public Document() {
		
	}
	
    public Document(int id, String title, Document masterDocument, List<Permission> permissions,
     				List<Section> sections, List<Document> slaveDocuments) {
    	this.id = id;
    	this.title = title;
    	this.masterDocument = masterDocument;
    	this.sections = sections;
    	this.slaveDocuments = slaveDocuments;
    	this.permissions = permissions;
    }
    
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public Document getMasterDocument() {
		return masterDocument;
	}

	public Document setMasterDocument(Document masterDocument) {
		return this.masterDocument = masterDocument;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public List<Document> getSlaveDocuments() {
		return slaveDocuments;
	}

	public void setSlaveDocuments(List<Document> slaveDocuments) {
		this.slaveDocuments = slaveDocuments;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
