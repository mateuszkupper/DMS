package business_objects;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;

@Entity(name = "document")
public class Document {
	
	@Id @GeneratedValue
	private int id;
	
	@Column(name = "`title`")
	private String title;
	
    @ManyToOne
    @MapsId	
	private Document masterDocument;
	
	@OneToMany(cascade = CascadeType.ALL)        
    private List<Section> sections;
    
	public Document() {
		
	}
	
    public Document(int id, String title, Document masterDocument,
    				List<Section> sections) {
    	this.id = id;
    	this.title = title;
    	this.masterDocument = masterDocument;
    	this.sections = sections;
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
}
