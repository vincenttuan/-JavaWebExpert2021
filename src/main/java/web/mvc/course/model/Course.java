package web.mvc.course.model;

public class Course {
	private Integer id; // 課程編號
	private String name; // 課程名稱
	private Integer credit; // 學分
	
	public Course() {
		
	}
	
	public Course(Integer id, String name, Integer credit) {
		this.id = id;
		this.name = name;
		this.credit = credit;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCredit() {
		return credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", credit=" + credit + "]";
	}
	
	
}
