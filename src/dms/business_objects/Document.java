package dms.business_objects;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

	@JsonIgnore
	@OneToMany(mappedBy="masterDocument", targetEntity=Document.class)
	@LazyCollection(LazyCollectionOption.FALSE)
    private Set<Document> slaveDocuments;

	@JsonIgnore
	@OneToMany(cascade={CascadeType.ALL}, targetEntity=Section.class, mappedBy="document")
	@LazyCollection(LazyCollectionOption.FALSE)
    private Set<Section> sections;

	@JsonIgnore
	@OneToMany(cascade = { CascadeType.ALL }, targetEntity = Permission.class, mappedBy = "document")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Permission> permissions;	
	
	@Column(name = "details")
	private String details;
	
	public Document() {
		
	}
	
    public Document(int id, String title, Document masterDocument, Set<Permission> permissions,
     				Set<Section> sections, Set<Document> slaveDocuments, String details) {
    	this.id = id;
    	this.title = title;
    	this.masterDocument = masterDocument;
    	this.sections = sections;
    	this.slaveDocuments = slaveDocuments;
    	this.permissions = permissions;
    	this.details = details;
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

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	public Set<Document> getSlaveDocuments() {
		return slaveDocuments;
	}

	public void setSlaveDocuments(Set<Document> slaveDocuments) {
		this.slaveDocuments = slaveDocuments;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
}
