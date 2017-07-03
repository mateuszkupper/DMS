package dms.business_objects;

import java.util.Date;

import org.ektorp.support.CouchDbDocument;

public class Paragraph extends CouchDbDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int section_id;
	private String text;
	private Date creation_date;
	private String prev_version_id;
	private int order_number;
	
	public Paragraph() {}
	
	public Paragraph(int section_id, String text, Date creation_date, String prev_version_id, int order_number) {
		this.setSection_id(section_id);
		this.setText(text);
		this.setCreation_date(creation_date);
		this.setPrev_version_id(prev_version_id);
		this.setOrder_number(order_number);
	}

	public int getSection_id() {
		return section_id;
	}

	public void setSection_id(int section_id) {
		this.section_id = section_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public String getPrev_version_id() {
		return prev_version_id;
	}

	public  void setPrev_version_id(String prev_version_id) {
		this.prev_version_id = prev_version_id;
	}

	public int getOrder_number() {
		return order_number;
	}

	public void setOrder_number(int order_number) {
		this.order_number = order_number;
	}
	
	
	
}
