package business_objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity(name = "notifications")
public class Notification {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne(targetEntity = Section.class)
	private Section sectionMaster;

	@ManyToOne(targetEntity = Section.class)
	private Section sectionSlave;

	@Column(name = "details")
	private String details;

	public Notification() {

	}

	public Notification(int id, Section sectionMaster, Section sectionSlave, String details) {
		this.id = id;
		this.sectionMaster = sectionMaster;
		this.sectionSlave = sectionSlave;
		this.details = details;
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
}
