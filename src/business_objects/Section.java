package business_objects;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "sections")
public class Section {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "couch_db_section_id")
	private String couch_db_section_id;

	@ManyToOne(targetEntity = Section.class)
	@JoinColumn(name = "previous_version_id")
	private Section previousVersion;

	@OneToMany(mappedBy = "previousVersion", targetEntity = Section.class)
	private List<Section> subsequentVersions = new ArrayList<Section>();

	@ManyToOne(targetEntity = Document.class)
	private Document document;

	@OneToMany(cascade = { CascadeType.ALL }, targetEntity = Section.class, mappedBy = "sectionSlave")
	private List<Notification> notificationsForSlaveSections;

	@OneToMany(cascade = { CascadeType.ALL }, targetEntity = Section.class, mappedBy = "sectionMaster")
	private List<Notification> notificationsForMasterSections;

	public Section() {

	}

	public Section(int id, String title, String couch_db_section_id, List<Notification> notificationsForSlaveSections,
			List<Notification> notificationsForMasterSections, Section previousVersion, Document document,
			List<Section> subsequentVersions) {
		this.id = id;
		this.title = title;
		this.couch_db_section_id = couch_db_section_id;
		this.previousVersion = previousVersion;
		this.document = document;
		this.subsequentVersions = subsequentVersions;
		this.notificationsForMasterSections = notificationsForMasterSections;
		this.notificationsForSlaveSections = notificationsForSlaveSections;
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

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public List<Section> getSubsequentVersions() {
		return subsequentVersions;
	}

	public void setSubsequentVersions(List<Section> subsequentVersions) {
		this.subsequentVersions = subsequentVersions;
	}

	public List<Notification> getNotificationsForSlaveSections() {
		return notificationsForSlaveSections;
	}

	public void setNotificationsForSlaveSections(List<Notification> notificationsForSlaveSections) {
		this.notificationsForSlaveSections = notificationsForSlaveSections;
	}

	public List<Notification> getNotificationsForMasterSections() {
		return notificationsForMasterSections;
	}

	public void setNotificationsForMasterSections(List<Notification> notificationsForMasterSections) {
		this.notificationsForMasterSections = notificationsForMasterSections;
	}
}
