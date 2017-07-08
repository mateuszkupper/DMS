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

@Entity(name = "sections")
public class Section {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "order_number")
	private int order_number;
	
	@Column(name = "title")
	private String title;

	@ManyToOne(targetEntity = Document.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Document document;

	@Column(name = "couch_db_section_id")
	private String couch_db_section_id;

	@ManyToOne(targetEntity = Section.class)
	@JoinColumn(name = "previous_version_id")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Section previousVersion;

	@JsonIgnore
	@OneToMany(mappedBy = "previousVersion", targetEntity = Section.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Section> subsequentVersions;	
	
	@JsonIgnore
	@OneToMany(cascade = { CascadeType.ALL }, targetEntity = Notification.class, mappedBy = "sectionSlave")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Notification> notificationsForSlaveSections;

	@JsonIgnore
	@OneToMany(cascade = { CascadeType.ALL }, targetEntity = Notification.class, mappedBy = "sectionMaster")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<Notification> notificationsForMasterSections;

	public Section() {

	}

	public Section(int id, String title, Set<Notification> notificationsForSlaveSections,
			Set<Notification> notificationsForMasterSections, Document document, int order_number, 
			String couch_db_section_id, Section previousVersion, Set<Section> subsequentVersions) {
		this.id = id;
		this.title = title;
		this.document = document;
		this.notificationsForMasterSections = notificationsForMasterSections;
		this.notificationsForSlaveSections = notificationsForSlaveSections;
		this.order_number = order_number;
		this.setCouch_db_section_id(couch_db_section_id);
		this.setSubsequentVersions(subsequentVersions);
		this.setPreviousVersion(previousVersion);
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

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Set<Notification> getNotificationsForSlaveSections() {
		return notificationsForSlaveSections;
	}

	public void setNotificationsForSlaveSections(Set<Notification> notificationsForSlaveSections) {
		this.notificationsForSlaveSections = notificationsForSlaveSections;
	}

	public Set<Notification> getNotificationsForMasterSections() {
		return notificationsForMasterSections;
	}

	public void setNotificationsForMasterSections(Set<Notification> notificationsForMasterSections) {
		this.notificationsForMasterSections = notificationsForMasterSections;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
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

	public Set<Section> getSubsequentVersions() {
		return subsequentVersions;
	}

	public void setSubsequentVersions(Set<Section> subsequentVersions) {
		this.subsequentVersions = subsequentVersions;
	}
}
