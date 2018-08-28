package ccgp.domain;

import java.util.Date;

public class Ccgp {

	private String title;
	private String area;
	private String people;
	private Date time;
	private String status;
	private String href;
	private String type;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getPeople() {
		return people;
	}
	public void setPeople(String people) {
		this.people = people;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Ccgp [title=" + title + ", area=" + area + ", people=" + people
				+ ", time=" + time + ", status=" + status + ", href=" + href
				+ ", type=" + type + "]";
	}
	
	
	
}
