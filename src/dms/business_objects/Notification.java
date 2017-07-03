package dms.business_objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity(name = "notifications")
public class Notification {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(targetEntity = Section.class)
	@JoinColumn(name = "section_master_id")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Section sectionMaster;

	@ManyToOne(targetEntity = Section.class)
	@JoinColumn(name = "section_slave_id")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Section sectionSlave;

	@Column(name = "details")
	private String details;

	@Column(name = "is_read")
	private boolean is_read;
	
	public Notification() {

	}

	public Notification(int id, Section sectionMaster, Section sectionSlave,
						String details, boolean is_read) {
		this.id = id;
		this.sectionMaster = sectionMaster;
		this.sectionSlave = sectionSlave;
		this.details = details;
		this.setIs_read(is_read);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Section getSectionMaster() {
		return sectionMaster;
	}

	public void setSectionMaster(Section sectionMaster) {
		this.sectionMaster = sectionMaster;
	}

	public Section getSectionSlave() {
		return sectionSlave;
	}

	public void setSectionSlave(Section sectionSlave) {
		this.sectionSlave = sectionSlave;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public boolean isIs_read() {
		return is_read;
	}

	public void setIs_read(boolean is_read) {
		this.is_read = is_read;
	}
}
