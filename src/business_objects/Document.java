package business_objects;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "documents")
public class Document {
	
	@Id @GeneratedValue
	private int id;
	
	@Column(name = "title")
	private String title;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="master_id")
	private Document masterDocument;
	
	@OneToMany(mappedBy="masterDocument", cascade={CascadeType.ALL})       
    private List<Document> slaveDocuments = new ArrayList<Document>();
	
	@OneToMany(cascade={CascadeType.ALL})        
    private List<Section> sections;
    
	public Document() {
		
	}
	
    public Document(int id, String title, Document masterDocument,
    				List<Section> sections, List<Document> slaveDocuments) {
    	this.id = id;
    	this.title = title;
    	this.masterDocument = masterDocument;
    	this.sections = sections;
    	this.slaveDocuments = slaveDocuments;
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
}
