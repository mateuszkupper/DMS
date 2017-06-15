package business_objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity(name = "document")
public class Section {
	
	@Id
	private int id;
	
	@Column(name = "`title`")
	private String title;

	@Column(name = "`couch_db_section_id`")
	private String couch_db_section_id;	
	
    @ManyToOne
    @MapsId
	private Section previousVersion;
	
	public Section(int id, String title, String couch_db_section_id,
						Section previousVersion) {
		this.id = id;
		this.title = title;
		this.couch_db_section_id = couch_db_section_id;
		this.previousVersion = previousVersion;
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
	
	public String getCouch_db_section_id() {
		return couch_db_section_id;
	}
	
	public void setCouch_db_section_id(String couch_db_section_id) {
		this.couch_db_section_id = couch_db_section_id;
	}

	public Section getPreviousVersion() {
		return previousVersion;
	}

	public void setPreviousVersion(Section previousVersion) {
		this.previousVersion = previousVersion;
	}	
}
